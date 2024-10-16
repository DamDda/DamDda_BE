package org.eightbit.damdda.project.repository;


import org.eightbit.damdda.project.domain.PackageRewards;
import org.eightbit.damdda.project.domain.ProjectPackage;
import org.eightbit.damdda.project.domain.ProjectRewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface PackageRewardsRepository extends JpaRepository<PackageRewards,Long> {

    @Query("SELECT DISTINCT pr.projectReward FROM PackageRewards pr WHERE pr.project.id = :projectId")
    List<ProjectRewards> findRewardsByProjectId(@Param("projectId") Long projectId);

    @Query("SELECT DISTINCT pr.projectReward FROM PackageRewards pr WHERE pr.projectPackage.id = :packageId")
    List<ProjectRewards> findRewardsByPackageId(@Param("packageId") Long packageId);

    @Query("SELECT pr FROM PackageRewards pr JOIN FETCH pr.projectReward WHERE pr.project.id = :projectId")
    List<PackageRewards> findAllRewardsByProjectIdWithProjectReward(@Param("projectId") Long projectId);

    @Query("select pr.rewardCount from PackageRewards pr where pr.projectPackage.id =:packageId AND pr.projectReward.id=:rewardId")
    int findRewardCountByRewardId(@Param("packageId") Long packageId, @Param("rewardId") Long rewardId);

    @Query("select pr from PackageRewards pr where  pr.projectReward.id=:rewardId")
    List<PackageRewards> findPackageRewardByRewardId(@Param("rewardId") Long rewardId);


//    /* supporting 패키지에서  supporting_project_id가 projectid와 일치하는 걸 같고 packageprice를 모두 더함
//     **/
//    //projectPackage가 재활용이 될 수 있나??
//    @Query("SELECT pr.projectPackage.totalSalesAmount FROM PackageRewards pr WHERE pr.project.id =: projectId")
//    List<String> findPackagePricesByProjectId(@Param("projectId") Long projectId);



}
