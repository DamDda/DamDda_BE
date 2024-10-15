package org.eightbit.damdda.order.service;

import lombok.RequiredArgsConstructor;
import org.eightbit.damdda.admin.repository.AdminProjectRepository;
import org.eightbit.damdda.order.domain.*;
import org.eightbit.damdda.order.dto.OrderDTO;
<<<<<<< Updated upstream
import org.eightbit.damdda.order.repository.*;
=======
import org.eightbit.damdda.order.dto.ProjectStatisticsDTO;
import org.eightbit.damdda.order.dto.SupportingPackageDTO;
import org.eightbit.damdda.project.domain.Project;
import org.eightbit.damdda.project.repository.ProjectRepository;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
<<<<<<< Updated upstream
=======
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
>>>>>>> Stashed changes
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
<<<<<<< Updated upstream
    private final OrderRepository orderRepository;
    private final DeliveryRepository deliveryRepository;
    private final PaymentRepository paymentRepository;
    private final SupportingProjectRepository supportingProjectRepository;
    private final SupportingPackageRepository supportingPackageRepository;
    @Autowired
    private AdminProjectRepository projectRepository;
=======
    private final org.eightbit.damdda.order.repository.OrderRepository orderRepository;
    private final org.eightbit.damdda.order.repository.DeliveryRepository deliveryRepository;
    private final org.eightbit.damdda.order.repository.PaymentRepository paymentRepository;
    private final org.eightbit.damdda.order.repository.SupportingProjectRepository supportingProjectRepository;
    private final org.eightbit.damdda.order.repository.SupportingPackageRepository supportingPackageRepository;
    private final org.eightbit.damdda.project.repository.ProjectRepository projectRepository;
    private final org.eightbit.damdda.member.repository.MemberRepository memberRepository;

>>>>>>> Stashed changes


    //주문 저장
    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        // 연관된 엔티티 생성 및 저장

        Delivery delivery = deliveryRepository.save(orderDTO.getDelivery());
        Payment payment = paymentRepository.save(orderDTO.getPayment());
        SupportingProject supportingProject = new SupportingProject();
        supportingProject.setSupportedAt(LocalDateTime.now()); // 후원 시간 설정
        supportingProject.setDelivery(delivery);
        supportingProject.setPayment(payment);
        supportingProject.setProject(orderDTO.getSupportingProject().getProject());
        supportingProject.setUser(orderDTO.getSupportingProject().getUser());

<<<<<<< Updated upstream
        supportingProject = supportingProjectRepository.save(supportingProject);

        SupportingPackage supportingPackage = supportingPackageRepository.save(orderDTO.getSupportingPackage());
=======
        // 프로젝트 id를 받아서 저장한 후-> 해당 프로젝트와 연결****
        Long projectId = orderDTO.getSupportingProject().getProject().getId();  // Project 엔티티의 ID를 가져옴
        System.out.println(projectId+"!");
        Project project=projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("프로젝트를 찾을 수 없습니다."));
        System.out.println("order service project"+project);

        //userId로 user찾기****
        Long userId = orderDTO.getSupportingProject().getUser().getId();  // User(Member) 엔티티의 ID를 가져옴
        System.out.println(userId+"!");

        Member member=memberRepository.getById(userId);
        System.out.println("order service member"+member);


        SupportingProject supportingProject = SupportingProject.builder()
                .user(member)
                .project(project)
                .supportedAt(LocalDateTime.now())
                .payment(payment)
                .delivery(delivery)
                .build();
        System.out.println("log: order service supporting project"+supportingProject);
        supportingProjectRepository.save(supportingProject);


        // 여러 개의 SupportingPackage를 처리할 수 있도록 Set을 사용
        Set<SupportingPackage> supportingPackages = new HashSet<>();

        // OrderDTO에서 여러 개의 SupportingPackage 가져오기
        for (SupportingPackage suppportingPackage : orderDTO.getSupportingPackages()) {
            SupportingPackage supportingPackage = SupportingPackage.builder()
                    .packageName(suppportingPackage.getPackageName())
                    .packagePrice(suppportingPackage.getPackagePrice())
                    .packageCount(suppportingPackage.getPackageCount())
                    .supportingProject(supportingProject)  // 어떤 프로젝트를 참조하는지 설정
                    .build();
            System.out.println("log: order service supporting package"+supportingPackage);
            supportingPackageRepository.save(supportingPackage);
            supportingPackages.add(supportingPackage);  // Set에 추가
        }
>>>>>>> Stashed changes

        // Order 엔티티 생성 및 저장
        Order order = Order.builder()
                .delivery(delivery)
                .payment(payment)
                .supportingProject(supportingProject)
                .supportingPackages(supportingPackages)
                .createdAt(LocalDateTime.now())
                .build();

        Order savedOrder=orderRepository.save(order);
        //후원 프로젝트 업데이트
//        Project project=savedOrder.getProject();
//        if (project != null) {
//            // 후원금액 추가
//            project.setFundsReceive(project.getFundsReceive() + order.getAmount());
//
//            // 후원자 수 추가
//            project.setSupporterCount(project.getSupporterCount() + 1);
//
//            // 프로젝트 업데이트
//            projectRepository.save(project);
//        }
        return savedOrder;

    }

<<<<<<< Updated upstream
    // 결제 상태 업데이트 메서드
    public Order updatePaymentStatus(Long orderId, String newStatus) {
        // orderId로 주문 정보 조회
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            // 결제 상태 업데이트
            order.getPayment().setPaymentStatus(newStatus);
            // 업데이트된 주문 정보 저장
            return orderRepository.save(order);
        }
        return null; // 주문을 찾지 못한 경우
    }

    // Order 조회 메서드
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null); // 주문이 존재하지 않으면 null 반환
    }

    // 주문 목록을 DTO로 변환하여 가져오는 메서드
    public List<OrderDTO> getMyOrders(Long userId) {
        List<Order> orders = orderRepository.findAllBySupportingProject_User_Id(userId);
        return orders.stream()
                .map(this::convertToDTO)
=======
    // userId로 주문 목록을 조회하는 메서드
    public List<OrderDTO> getOrdersByUserId(Long userId) {
        List<Order> orders = orderRepository.findAllBySupportingProject_User_Id(userId);  // userId로 주문 리스트 조회
        return orders.stream().map(order -> OrderDTO.builder()
                        .delivery(order.getDelivery())  // 배송 정보
                        .payment(order.getPayment())    // 결제 정보
                        .supportingProject(order.getSupportingProject())  // 후원 프로젝트 정보
                        .supportingPackages(order.getSupportingPackages())  // 선물 구성 정보
                        .build())
                .collect(Collectors.toList());  // List<OrderDTO>로 변환
    }


    // 특정 주문 정보 가져오기 (orderId로 조회)
    public Optional<OrderDTO> getOrderById(Long orderId) {
        return orderRepository.findById(orderId).map(order -> {
            // Order 엔티티를 OrderDTO로 변환
            return OrderDTO.builder()
                    .delivery(order.getDelivery())  // 배송 정보
                    .payment(order.getPayment())    // 결제 정보
                    .supportingProject(order.getSupportingProject())  // 후원 프로젝트 정보
                    .supportingPackages(order.getSupportingPackages())  // 선물 구성 정보
                    .build();
        });
    }

    // 사용자의 모든 주문 정보 및 결제 정보 가져오기
    public List<OrderDTO> getOrdersWithPaymentByUserId(Long userId) {
        // userId로 SupportingProject 가져오기
        System.out.println("User ID in Service: " + userId);

        List<SupportingProject> supportingProjects = supportingProjectRepository.findAllByUser_Id(userId);

        System.out.println("Supporting Projects: " + supportingProjects);

        // 각 후원 프로젝트에 속한 주문을 모두 조회
        return supportingProjects.stream()
                .flatMap(supportingProject -> orderRepository.findAllBySupportingProject(supportingProject).stream())
                .map(order -> OrderDTO.builder()
                        .delivery(order.getDelivery())  // 배송 정보
                        .payment(order.getPayment())    // 결제 정보
                        .supportingProject(order.getSupportingProject())  // 후원 프로젝트 정보
                        .supportingPackages(order.getSupportingPackages())  // 선물 구성 정보
                        .build())
>>>>>>> Stashed changes
                .collect(Collectors.toList());
    }

    // 주문 상세 정보를 DTO로 반환하는 메서드
    public OrderDTO getOrderDetails(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + orderId));
        return convertToDTO(order);
    }

    // 엔티티를 DTO로 변환하는 메서드
    private OrderDTO convertToDTO(Order order) {
        // DTO를 생성하면서 필요한 정보는 엔티티에서 가져옵니다.
        return new OrderDTO(
                order.getDelivery(),             // Delivery 엔티티
                order.getPayment(),              // Payment 엔티티
                order.getSupportingProject(),    // SupportingProject 엔티티
                order.getSupportingPackage()     // SupportingPackage 엔티티
        );

    }


<<<<<<< Updated upstream
=======
    //결제 취소
//    public OrderDTO updateOrderStatus(Long orderId, String status) {
//        // 주문 ID로 주문을 찾기
//        Optional<Order> orderOptional = orderRepository.findById(orderId);
//        System.out.println(orderOptional+"*******");
//        if (orderOptional.isPresent()) {
//            Order order = orderOptional.get();
//            order.getSupportingProject().getPayment().setPaymentStatus(status); // 결제 상태 업데이트
//            orderRepository.save(order); // 변경된 주문 저장
//
//            // Order를 OrderDTO로 변환하여 반환
//            return OrderDTO.builder()
//                    .delivery(order.getDelivery())
//                    .payment(order.getPayment())
//                    .supportingProject(order.getSupportingProject())
//                    .supportingPackage(order.getSupportingPackage())
//                    .build();
//        } else {
//            // 주문이 없을 경우 적절한 예외 처리 (예: 주문을 찾을 수 없음)
//            throw new EntityNotFoundException("Order not found with ID: " + orderId);
//        }
//    }
    public void updateOrderStatus(Long orderId, String paymentStatus) {
        // 주문 ID로 주문을 조회
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        // 결제 상태 업데이트
        order.getSupportingProject().getPayment().setPaymentStatus(paymentStatus);
        orderRepository.save(order);  // 변경된 상태를 저장
    }

    public String cancelPayment(Long paymentId, String paymentStatus) {
        // paymentId로 결제를 찾아 해당 결제 정보를 가져옵니다.
        Optional<SupportingProject> optionalSupportingProject = supportingProjectRepository.findById(paymentId);
        if (optionalSupportingProject.isPresent()) {
            SupportingProject supportingProject = optionalSupportingProject.get();

            // 결제 상태 업데이트
            if (supportingProject.getPayment() != null) {
                supportingProject.getPayment().setPaymentStatus(paymentStatus); // 결제 상태 업데이트
                supportingProjectRepository.save(supportingProject); // 변경된 상태를 저장
                return "결제 취소됨";
            } else {
                throw new IllegalArgumentException("Payment not found for this supporting project");

            }
        } else {
            throw new IllegalArgumentException("SupportingProject not found with id: " + paymentId);
        }

    }

    //**********여기!!!!!결제 취소 로직 orderId가 필요한지 어쩐지 모르겠어요!***************

    //order 테이블 가져오기
    public List<Order> getOrdersBySupportingProject(SupportingProject supportingProject) {
        return orderRepository.findAllBySupportingProject(supportingProject);
    }

    public OrderDTO convertToOrderDTO(Order order) {
        return OrderDTO.builder()
                .delivery(order.getDelivery())
                .payment(order.getPayment())
                .supportingProject(order.getSupportingProject())
                .supportingPackages(order.getSupportingPackages())
                .build();
    }

    //SupportingProject - 모든 주문 정보를 가져오는 서비스 메서드
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> {
            // Order 엔티티를 OrderDTO로 변환
            return OrderDTO.builder()
                    .delivery(order.getDelivery())  // 배송 정보
                    .payment(order.getPayment())    // 결제 정보
                    .supportingProject(order.getSupportingProject())  // 후원 프로젝트 정보
                    .supportingPackages(order.getSupportingPackages())  // 선물 구성 정보
                    .build();
        }).collect(Collectors.toList());
    }

    //member id를 통해 프로젝트 id 가져오기
    public Long getUserProjectId(Long memberId) {
        List<Project> projects = orderRepository.findProjectsByMemberId(memberId);
        if (!projects.isEmpty()) {
            return projects.get(0).getId(); // 첫 번째 프로젝트 ID 반환
        }
        return null; // 프로젝트가 없으면 null 반환
    }

    // ProjectStatistics 후원 프로젝트의 시작일, 마감일, 달성률, 총 후원 금액, 후원자 수, 남은 기간을 가져옴
    //프로젝트 통계 정보를 가져오는 서비스 메서드
    public ProjectStatisticsDTO getProjectStatistics(Long projectId) {

        //1. 내 프로젝트 ID 찾기
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        //2. 총 후원 금액가져오기->
        List<String> packagePrices=supportingPackageRepository.findPackagePricesByProjectId(projectId);

        // String을 Integer로 변환한 후, 합계를 계산
        Long totalAmount = packagePrices.stream()
                .filter(price -> price != null && !price.isEmpty())  // null과 빈 문자열을 체크하여 제외
                .map(Integer::parseInt)  // String을 Integer로 변환
                .mapToLong(Integer::longValue)  // Integer를 Long으로 변환
                .sum();  // 합계 계산


        //3. 후원자 수 가져오기
        Long totalSupporters =supportingPackageRepository.getTotalSupporters(projectId);

        // 4. 남은 기간 계산
        LocalDate today = LocalDate.now();

        // 프로젝트 종료일을 SupportingPackage에서 가져옴
        Timestamp endDateTimestamp = supportingPackageRepository.findProjectEndDateByProjectId(projectId);
        System.out.println(endDateTimestamp+"0000000");
        // Timestamp를 LocalDateTime으로 변환 후 LocalDate로 변환
        LocalDateTime endDateTime = endDateTimestamp.toLocalDateTime();
        LocalDate endDate = endDateTime.toLocalDate();

        // 종료일과 오늘 날짜 사이의 남은 일수 계산
        long remainingDays = ChronoUnit.DAYS.between(today, endDate);

        // 4. created_at 가져오기
        Timestamp createdAtTimestamp = supportingPackageRepository.getCreatedAtByProjectId(projectId);
        LocalDateTime createdAtTime = createdAtTimestamp.toLocalDateTime();
        LocalDate createdAt = createdAtTime.toLocalDate();
        // 5. target Funding
        Long targetFunding=supportingPackageRepository.getTargetFundingByProjectId(projectId);
        System.out.println(targetFunding+"!!");
        // 5. DTO로 통계 정보를 반환
        return ProjectStatisticsDTO.builder()
                .startDate(createdAtTimestamp) // created_at 값을 Timestamp로 사용
                .endDate(endDateTimestamp)     // endDate 값을 Timestamp로 사용
                .totalSupportAmount(totalAmount != null ? totalAmount : 0)
                .totalSupporters(totalSupporters != null ? totalSupporters : 0)
                .remainingDays(Math.max(remainingDays, 0)) // 남은 기간이 음수면 0
                .targetFunding(targetFunding)
                .build();


    }
>>>>>>> Stashed changes



}
