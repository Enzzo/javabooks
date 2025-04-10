package ru.vasilev.hibernate;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.h2.jdbcx.JdbcDataSource;

public class JndiSetup {
	public static void bindDataSource() throws NamingException{
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false");
        ds.setUser("sa");
        ds.setPassword("");
        
        InitialContext context = new InitialContext();
        context.bind("myDS", ds);
        
        System.out.println("DataSource с именем 'myDS' успешно привязан!");
	}
}