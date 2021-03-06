package hellojpa;

import hellojpa.items.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setCreatedDate(LocalDateTime.now());
            member.setCreatedBy("admin");
            member.changeTeam(team);
            em.persist(member);


            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            System.out.println("findMember = " + findMember.getTeam().getClass());

            System.out.println("================");
            findMember.getTeam().getName();

            System.out.println("================");

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
