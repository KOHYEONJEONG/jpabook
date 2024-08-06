package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

//    @Column(name = "ORDER_ID")
//    private Long orderId;

    //객체지향스럽게 변경됨.
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

//    @Column(name = "ITEM_ID")
//    private Long itmeId;

    //객체지향스럽게 변경됨.
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;


    @Column(name = "ORDER_PRICE")
    private int orderPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
