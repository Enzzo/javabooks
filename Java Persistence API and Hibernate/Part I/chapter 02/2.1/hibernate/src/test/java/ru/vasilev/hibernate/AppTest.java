package ru.vasilev.hibernate;

import java.time.LocalDateTime;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import junit.framework.TestCase;
import ru.vasilev.hibernate.model.Message;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
	private SessionFactory sessionFactory;
	
	@Override
	protected void setUp() {
		final StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().build();
		try {
			sessionFactory = 
					new MetadataSources(registry)
					.addAnnotatedClass(Message.class)
					.buildMetadata()
					.buildSessionFactory();
		}
		catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	@Override
	protected void tearDown() {
		if(sessionFactory != null) {
			sessionFactory.close();
		}
	}
	
	public void testBasicUsage() {
		sessionFactory.inTransaction(session -> {
			session.persist(new Message("Hello world", LocalDateTime.now()));
			session.persist(new Message("Hello again", LocalDateTime.now()));
		});
		
		sessionFactory.inTransaction(session -> {
			session.createSelectionQuery("from Message", Message.class).getResultList()
			.forEach(message -> System.out.println("Message (" + message.getDate() + ") : " + message.getMessage()));
		});
	}
}