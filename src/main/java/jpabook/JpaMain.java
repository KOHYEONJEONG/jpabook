package jpabook;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{//정상수행

            //객체지향 스럽지 않은 설계(객체를 관계형 DB쪽에 맞춰서 설계한 방식 )
            /*
                Order order = em.find(Order.class, 1L);
                Long memberId = order.getMemberId(); /// 이렇게 식별자가 바로 있으면 흐름이 끊기는 거지
                Member member = em.find(Member.class, memberId);
                Member findeMember = order.getMember();
            */

            tx.commit();
        }catch (Exception e){
            //롤백
            em.close();
        }
        emf.close();


    }
}
