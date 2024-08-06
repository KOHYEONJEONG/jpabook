package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID") //요새 DB에는 소문자 member_id, 예전에는 MEMBER_ID
    private Long id;

    private String name;
    private String city;
    private String street;

    @Column(name = "ZIP_CODE")
    private String zipcode;

    //양방향 연관관계
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    //setter 만들때는 고심해봐야한다.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Member() {
    }
}
