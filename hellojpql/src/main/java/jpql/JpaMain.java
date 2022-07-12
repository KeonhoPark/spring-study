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
            Member member = new Member();

            member.setUserName("park");
            member.setAge(10);
            em.persist(member);

            List<MemberDto> resultList = em.createQuery("select new jpql.MemberDto(m.userName, m.age) from Member m", MemberDto.class)
                    .getResultList();

            for (MemberDto memberDto : resultList) {
                System.out.println("member.getUserName() = " + memberDto.getUserName());
                System.out.println("member.getAge() = " + memberDto.getAge());
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
