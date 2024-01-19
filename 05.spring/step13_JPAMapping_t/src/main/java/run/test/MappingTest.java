package run.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.spring.jpa.entity.Member;

public class MappingTest {
	
	public static void mappingTest(EntityManager em) {
		// insert - team, member
//		Team team = new Team();
//		team.setName("Tech");
//		em.persist(team);
//		
//		Member suhan = new Member();
//		suhan.setName("suhan");
//		suhan.setAge(28);
//		suhan.setTeamId(team.getId());
//		em.persist(suhan);
		
		// select : member 속해있는 팀의 정보 출력
		// member -> getTeamId() -> team
		// v0
//		Member findMember = em.find(Member.class, 1L);
//		Long teamId = findMember.getTeamId();
//		Team findTeam =  em.find(Team.class, teamId);
		
		
		// v1
//		Member findMemberV1 = em.find(Member.class, 1L);
//		System.out.println(findMemberV1);

		// v2
//		Member findMemberV2 = em.find(Member.class, 1L);
//		System.out.println(findMemberV2);
		
//		Team findTeamV2 = em.find(Team.class, 1L);
//		System.out.println(findTeamV2);
//		findTeamV2.getMembers()
		
		// strategy
//		Team findTeamStrategy = em.find(Team.class, 1L);
//		
//		Member daewon = new Member();
//		daewon.setName("daewon");
//		daewon.setAge(27);
//		daewon.setTeam(findTeamStrategy);
//		em.persist(daewon);
		
		/* EAGER
		  
		 
		 */
		
		/* LAZY
		 Hibernate: 
		    select
		        member0_.id as id1_0_0_,
		        member0_.age as age2_0_0_,
		        member0_.name as name3_0_0_,
		        member0_.team_id as team_id4_0_0_ 
		    from
		        Member member0_ 
		    where
		        member0_.id=?
		 */
//		Member findMemberStrategy = em.find(Member.class, 1L);
//		System.out.println(findMemberStrategy);
		
		// 1. TypedQuery : JPA에서 Query를 객체 -> 변환 타입 명확할때
		String query1 = "SELECT m FROM Member m";
		TypedQuery<Member> typedQuery1 = em.createQuery(query1, Member.class);
		List<Member> memberList1 = typedQuery1.getResultList();
//		System.out.println(memberList1);
		
		// *** 파라미터 사용!!!
		// 1) 위치 파라미터 사용법
		String paramQuery1 = "SELECT m FROM Member m WHERE m.id = ?1";
		TypedQuery<Member> paramTypedQuery1 = em.createQuery(paramQuery1, Member.class);
		Member paramResult1 = paramTypedQuery1
								.setParameter(1, 2L)
								.getSingleResult();
//		System.out.println(paramResult1);
		
		// 2) 이름
		String paramQuery2 = "SELECT m FROM Member m WHERE m.id = :memberId";
		TypedQuery<Member> paramTypedQuery2 = em.createQuery(paramQuery2, Member.class);
		Member paramResult2 = paramTypedQuery2
								.setParameter("memberId", 2L)
								.getSingleResult();
		System.out.println(paramResult2);
		
		
		
		
		
		// 2. Query: JPA에서 Query를 객체 -> 변환 타입 불명확할때
		String query2 = "SELECT m FROM Member m";
		Query untypedQuery2 = em.createQuery(query2);
		List memberList2 = untypedQuery2.getResultList();
//		System.out.println(memberList2);
		
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		mappingTest(em);
		
		
		tx.commit();
	}

}
