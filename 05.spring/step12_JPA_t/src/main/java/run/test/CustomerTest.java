package run.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.spring.jpa.entity.Customer;
import com.spring.jpa.enumtype.GradeType;

public class CustomerTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// insert
		Customer newCustomer = new Customer("c-1003", "DEV", new Date(), GradeType.GOLD);
		em.persist(newCustomer);
		
		
		
		
		
		tx.commit();
	}
}
