package ru.vasilev.hibernate;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import ru.vasilev.hibernate.env.DatabaseProduct;
import ru.vasilev.hibernate.env.TransactionManagerSetup;
import ru.vasilev.hibernate.model.Message;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
    	System.out.println("main start");
    	try {
//            // Привязываем DataSource к JNDI (требуется для jta-data-source)
            JndiSetup.bindDataSource();
        } catch (NamingException e) {
            System.err.println("Ошибка привязки DataSource: " + e.getMessage());
            return;
        }
    	TransactionManagerSetup tm = new TransactionManagerSetup(DatabaseProduct.H2, null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");
        
//        UserTransaction tx = TransactionManagerTest.TM.getUserTransaction();
        

        // Получаем UserTransaction напрямую через созданный менеджер
        UserTransaction tx = tm.getUserTransaction();
        tx.begin();
        EntityManager em = emf.createEntityManager();
        
        Message message = new Message();
        message.setText("Hello world");
        em.persist(message);
        
        tx.commit();
        em.close();
        System.out.println("main finished");
    }
}