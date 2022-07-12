package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            for (int i = 0 ; i < 100; i++){
                Member member = new Member();
                member.setAge(i);
                member.setUserName("member" + i);
                em.persist(member);
            }

            List<Member> resultList = em.createQuery("select m from Member m order by m.age desc ", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            System.out.println("resultList.size() = " + resultList.size());
            for (Member m : resultList) {
                System.out.println("m.toString() = " + m.toString());
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
