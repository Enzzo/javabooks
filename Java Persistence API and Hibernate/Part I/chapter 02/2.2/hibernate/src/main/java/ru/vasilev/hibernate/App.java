package ru.vasilev.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {// throws SystemException, SecurityException, IllegalStateException, RollbackException{//, HeuristicMixedException, HeuristicRollbackException {
    	System.out.println("main start");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");
//        
//        UserTransaction tx = TransactionManagerTest.TM.getUserTransaction();
//        tx.begin();
//        EntityManager em = emf.createEntityManager();
//        
//        Message message = new Message();
//        message.setText("Hello world");
//        em.persist(message);
//        
//        tx.commit();
//        em.close();
    }
}