package com.dao;
import java.util.*;
import java.io.*;

import com.model.*;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class CustomerDaoImpl  implements Dao{

    private  SessionFactory sessionFactory;
	
	public CustomerDaoImpl(){
		  try {
	            
			    Configuration configuration = new Configuration().configure();
				ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
				registry.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

				// builds a session factory from the service registry
				 sessionFactory = configuration.buildSessionFactory(serviceRegistry);    	
	           
	        }
	        catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            ex.printStackTrace();
	            throw new ExceptionInInitializerError(ex);
	        }
		
		
	}
	@Override
	public void add(Object o){
		Session session = null;
		Transaction tx = null;
		Customer customer=(Customer)o;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(customer);
			tx.commit();
			session.flush();
		}
		catch(Exception e){
			
		}
		finally{
			
			session.close();
		}
	}

	@Override
	public void delete(int index) {
		Session session = null;
		Transaction tx = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			Query query=session.createQuery("delete Order where  customer_id= :id");
			query.setInteger("id",index);
		    int result=query.executeUpdate();
			
		    query=session.createQuery("delete Customer where  customer_id= :id");
			query.setInteger("id",index);
			 result=query.executeUpdate();
		
			tx.commit();
			session.flush();
			
		}
		catch(Exception e){
		
		
		}
		finally{
			
			session.close();
		}
		
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		List<Customer> customers=null;
		Session session = null;
		Transaction tx = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
						
			customers=session.createQuery("from Customer").list();
				
			tx.commit();
			session.flush();
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
		
		
		return customers;
		
		
		
	}

	@Override
	public void update(Object o,int index) {
		// TODO Auto-generated method stub
	
		Session session = null;
		Transaction tx = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Customer customer=(Customer)o;
		   session.saveOrUpdate(customer);
			

			tx.commit();
			session.flush();
			
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
		
	}
	public Customer getCustomer(int index){

		Session session = null;
		Transaction tx = null;
		Customer customer=null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("from Customer where customer_id= :id");
			query.setInteger("id",index);
		   customer= (Customer) query.uniqueResult();
		  
			tx.commit();
			session.flush();
			
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
        return	customer;
	}
	public Customer getCustomer(String username){

		Session session = null;
		Transaction tx = null;
		 Customer customer=null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("from Customer where username= :username");
			query.setString("username",username);
		   customer= (Customer) query.uniqueResult();
			tx.commit();
			session.flush();
			
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
        return	customer;
	}

}
