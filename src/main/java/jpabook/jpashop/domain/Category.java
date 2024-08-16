package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //셀프조인
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private  Category parent;

    //셀프조인
    @OneToMany(mappedBy = "parent")
    private List<Category> child= new ArrayList<>();

    //가정: 하나의 카테고리 여러 아이템이 들어갈 수 있고 한 아이템도 여러 카테고리에 소속될 수 있다.
    @ManyToMany
    @JoinTable(name="CATEGORY_ITEM", //카테고리와 Item을 잇는 중간 테이블(ERD에 표시되어 있음)
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),//내가 조인해야하는건 이 컬럼이고
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")//반대쪽에서 조인해야하는 건 이 컬럼이다.
    )
    private List<Item> items= new ArrayList<>();
    //N:M 관계는 1:N, N:1로
    //테이블의 N:M 관계는 💥중간테이블을 이용해서 1:N, N:1
    //💥ManyToMany는 제약: 필드 추가x, 엔티티 테이블 불일치
    //실전에서는 @ManyToMany 사용 x
}
