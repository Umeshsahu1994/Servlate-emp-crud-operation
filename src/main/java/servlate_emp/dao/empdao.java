package servlate_emp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import servlate_emp.dto.emp;

public class empdao {
	
	public static void saveStudent(emp s) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("umeshs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(s);
		entityTransaction.commit();
	}
	public static emp loginemp(String email,String password) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("umeshs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query qr= entityManager.createQuery("select e from emp e where e.email=?1 and e.password=?2");
		qr.setParameter(1, email);
		qr.setParameter(2, password);
		
		emp list = (emp) qr.getSingleResult();
		
		return list;
	
	}
	public static emp update(int id,String name) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("umeshs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		emp pr = entityManager.find(emp.class,id);
		if(pr!=null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			pr.setName(name);
			entityManager.merge(pr);
			entityTransaction.commit();
			return pr;
			
		}
		return null;
	}
	public static emp delet(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("umeshs");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		emp ut = entityManager.find(emp.class, id);
		
		
		if(ut!=null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(ut);
			entityTransaction.commit();
			return ut;
			
		}
		else {
			System.out.println("invalid details");
		return null;
		}
		
				}
	
	
	

}
