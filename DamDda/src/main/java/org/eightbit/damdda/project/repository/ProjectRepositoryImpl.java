package org.eightbit.damdda.project.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j2;
import org.eightbit.damdda.project.domain.QProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.eightbit.damdda.project.domain.Project;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Repository
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ProjectRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Page<Project> findProjects(Long memberId, String category, String search, String progress, List<String> sortConditions, Pageable pageable) {
        QProject project = QProject.project;
        BooleanBuilder builder = new BooleanBuilder();

        // 1. 카테고리 필터 (all인 경우 필터링 안 함)
        if (category != null && !"all".equals(category)) {
            builder.and(project.category.name.eq(category));
//            builder.and(project.category.name.eq(category));
        }

        // 2. 검색어 필터 (%search%)
        if (search != null && !search.isEmpty()) {
            builder.and(
                    project.title.containsIgnoreCase(search)
                            .or(project.description.containsIgnoreCase(search))
                            .or(project.descriptionDetail.containsIgnoreCase(search))
                            .or(project.tags.any().name.containsIgnoreCase(search))
            );
        }

        // 3. progress 필터
        if (progress != null) {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            if ("ongoing".equals(progress)) {
                builder.and(project.startDate.before(now).and(project.endDate.after(now)));
            } else if ("upcoming".equals(progress)) {
                builder.and(project.startDate.after(now));
            } else if ("completed".equals(progress)) {
                builder.and(project.endDate.before(now));
            }
        }

        // 4. 정렬 처리 (동적 정렬)
        OrderSpecifier<?>[] orderSpecifiers = getOrderSpecifiers(sortConditions, project);


        // 데이터 조회 및 페이징 처리
        List<Project> content = queryFactory
                .select(project)  // 여기에 Project 엔티티를 명시적으로 지정
                .from(project)
                .where(builder)
                .orderBy(orderSpecifiers)
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
                .fetch();

        log.info("!11111111111111111111111111111111111"+content.size());
        log.info("Builder conditions: " + builder.toString());
        log.info("Sort Conditions: " + sortConditions);
        log.info("Order specifiers: " + Arrays.toString(orderSpecifiers));


        // 전체 개수 조회
        long total = queryFactory.selectFrom(project)
                .where(builder)
                .fetchCount();



        // PageImpl 객체로 반환
        return new PageImpl<>(content, pageable, total);

//        // 5. 쿼리 실행
//        return queryFactory.selectFrom(project)
//                .where(builder)
//                .orderBy(orderSpecifiers)  // 정렬 조건 추가
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
    }

    private OrderSpecifier<?>[] getOrderSpecifiers(List<String> sortConditions, QProject project) {
        List<OrderSpecifier<?>> orderSpecifiers = new ArrayList<>();

        // 정렬 조건이 비어 있으면 기본 정렬 추가
        if (sortConditions == null || sortConditions.isEmpty()) {
            log.info("Sort conditions are empty, using default sort.");
            orderSpecifiers.add(project.id.desc());  // 기본 정렬 조건
        } else {
            for (String condition : sortConditions) {
                switch (condition) {
                    case "likeCnt":
                        orderSpecifiers.add(project.likeCnt.desc());
                        break;
                    case "endDate":
                        orderSpecifiers.add(project.endDate.asc());
                        break;
                    case "viewCnt":
                        orderSpecifiers.add(project.viewCnt.desc());
                        break;
                    case "supporterCnt":
                        orderSpecifiers.add(project.supporterCnt.desc());
                        break;
                    case "targetFunding":
                        orderSpecifiers.add(project.targetFunding.desc());
                        break;
                    case "registDate":
                        orderSpecifiers.add(project.createdAt.desc());
                        break;
                    case "fundsReceive":
                        orderSpecifiers.add(project.fundsReceive.desc());
                        break;
                    default:
                        log.warn("Unknown sort condition: " + condition);
                        break;
                }
            }
        }


        return orderSpecifiers.toArray(new OrderSpecifier<?>[0]);
    }
}
