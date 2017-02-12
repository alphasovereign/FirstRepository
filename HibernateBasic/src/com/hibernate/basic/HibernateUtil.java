package com.hibernate.basic;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.basic.model.Phone;
import com.hibernate.basic.model.User;
import com.hibernate.basic.model.onetomany.Account;
import com.hibernate.basic.model.onetomany.UserAccount;

public class HibernateUtil {

	
	
	public static void main(String[] args) {

		/*User user =  new User();
		user.setUser_name("Alpha Sovereign");
		Phone phone = new Phone();
		phone.setPhone_name("iPhone");
		
		user.setPhone(phone);
		phone.setUser(user);*/
		
		
		// Create Objects for OneToMany
		UserAccount ua = new UserAccount();
		ua.setUser_name("Sovereign Alpha");
	
		Account ac = new Account();
		ac.setAcc_number("100234567");
		ac.setUserAccount(ua);
		
		Account ac2 = new Account();
		ac2.setAcc_number("198347587");
		ac2.setUserAccount(ua);
		
		Set<Account> acs = new HashSet<Account>();
		acs.add(ac);
		acs.add(ac2);
		ua.setAccounts(acs);
		
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		//Testing OneToOne
		//session.save(user);
		
		//Testing OneToMany
		session.save(ua);
		session.save(ac);
		session.save(ac2);
		//Commit transaction
		session.getTransaction().commit();
//		System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}
	
	//XML based configuration
	private static SessionFactory sessionFactory;
	
	//Annotation based configuration
	private static SessionFactory sessionAnnotationFactory;
	
	//Property based configuration
	private static SessionFactory sessionJavaConfigFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Hibernate Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionAnnotationFactory() {
    	try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate-annotation.cfg.xml");
        	System.out.println("Hibernate Annotation Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate Annotation serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}

    
    
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
	
	public static SessionFactory getSessionAnnotationFactory() {
		if(sessionAnnotationFactory == null) sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }
	
	
	
}