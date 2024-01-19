package run.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.spring.jpa.entity.Member;

public class MemberTest {
	public static void main(String[] args) {
		// EMF
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		
		// EM
		EntityManager em = emf.createEntityManager();
		
		// TX : begin() ~ 작업 수행 ~  commit()
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// insert
		Member member1 = new Member("dev-1001", "DEV");
//		em.persist(member1);
		
		Member member2 = new Member("dev-1002", "DEVOPS");
//		em.persist(member2);
		
		
		
		
		// select : select * from member where id = ?
		Member findMember = em.find(Member.class, "dev-1001");
//		System.out.println(findMember);
		
		// selectAll : select * from member
		String jpql = "select m from Member m";
		List<Member> memberList = em.createQuery(jpql, Member.class).getResultList();
		System.out.println(memberList);
		
		// update : dev-1002의 이름을 IT 변경
// 		update member set name = 'IT' where id = 'dev-1002';
		Member dev1002 = em.find(Member.class, "dev-1002");
//		dev1002.setName("IT");
		
		// delete : delete from member where id = 'dev-1002';
		em.remove(dev1002);
		
		tx.commit();
		
	}
}
