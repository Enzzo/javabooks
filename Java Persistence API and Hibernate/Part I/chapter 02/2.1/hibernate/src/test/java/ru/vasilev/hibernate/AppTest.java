package ru.vasilev.hibernate;

import java.time.LocalDateTime;
import java.util.function.Consumer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import junit.framework.TestCase;
import ru.vasilev.hibernate.model.Message;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	protected void setUp() {
		entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorldPU");
	}
	
	@Override
	protected void tearDown() {
		entityManagerFactory.close();
	}
	
	void inTransaction(Consumer<EntityManager> work) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			work.accept(entityManager);
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
		finally {
			entityManager.close();
		}
	}
	
	public void testBasicUsage() {
		inTransaction(entityManager -> {
			entityManager.persist(new Message("Hello world", LocalDateTime.now()));
			entityManager.persist(new Message("Hello again", LocalDateTime.now()));
		});
		
		inTransaction(entityManager -> {
			entityManager.createQuery("select m from Message m", Message.class).getResultList()
			.forEach(message -> System.out.println("Message (" + message.getDate() + ") : " + message.getMessage()));
		});
	}
}