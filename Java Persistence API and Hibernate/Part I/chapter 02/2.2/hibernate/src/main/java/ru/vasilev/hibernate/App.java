
package ru.vasilev.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

import bitronix.tm.TransactionManagerServices;
import ru.vasilev.hibernate.model.Message;

public class App {
    public static void main(String[] args) throws Exception {EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");
        
        UserTransaction tx = TransactionManagerServices.getTransactionManager();
        tx.begin();
        
        EntityManager em = emf.createEntityManager();
        Message message = new Message();
        
        message.setText("Hello world");
        em.persist(message);
        
        tx.commit();
        
        em.close();
    }
}