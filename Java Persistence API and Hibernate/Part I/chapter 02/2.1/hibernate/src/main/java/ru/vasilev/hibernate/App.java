package ru.vasilev.hibernate;

import javax.transaction.UserTransaction;

import bitronix.tm.TransactionManagerServices;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args) throws Exception{
    	
    	UserTransaction tx = TransactionManagerServices.getTransactionManager();
    	
    	try {
    		tx.begin();
    		System.out.println("Hello world");
    		tx.commit();
    	}catch(Exception e) {}
    }
}