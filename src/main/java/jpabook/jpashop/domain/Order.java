package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private long id;

    //객체지향스럽지 않음!
    //    @Column(name = "MEMBER_ID")
    //    private long memberId;

    //객체지향스럽게 조회
    @ManyToOne // 주문 입장에서는 주문은 여러 건이 올 수 있으며, 주문한 회원(Member)은 무조건 하나
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)  //STRING으로 해주자, 기본타입 ORDINAL을 사용시 수선가 꼬인다.
    private OrderStatus orderStatus;

    //양방향 연관관계
    @OneToMany(mappedBy = "order")//연관관계의 주인은 누구야? OrderItem 객체에 있는 order를 말하는 것.
    private List<OrderItem> orderItems = new ArrayList<>();

    //편의 메소드 생성했음. - 양방향
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);  // OrderItem에서 Order를 참조할 수 있도록 OrderItem의 order를 this로 설정
    }

    public Member getMember() {
        return member;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setMember(Member member) {
        this.member = member;
    }



//    public long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(long memberId) {
//        this.memberId = memberId;
//    }
}
