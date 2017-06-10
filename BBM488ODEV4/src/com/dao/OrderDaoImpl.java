package com.dao;
import java.util.*;
import java.io.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.model.*;
public class OrderDaoImpl  implements Dao{
	 private  SessionFactory sessionFactory;
    public OrderDaoImpl(){
    
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
	public void add(Object o) {
	   
		Session session = null;
		Transaction tx = null;
		Order order=(Order)o;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(order);
			tx.commit();
			session.flush();
		}
		catch(Exception e){
			e.printStackTrace();
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
			
			
			Query query=session.createQuery("delete Order where  order_id= :id");
			query.setInteger("id",index);
			int result=query.executeUpdate();
		
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
		List<Order> orders=null;
		
		Session session = null;
		Transaction tx = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			
			orders=session.createQuery("from Order").list();
			
			
		
			tx.commit();
			session.flush();
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
		
		
		
		
		
		
		
		return orders;				
	}

	@Override
	public void update(Object o,int index) {
		Session session = null;
		Transaction tx = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
		    Order order=(Order)o;	
		    session.saveOrUpdate(order);
			

			tx.commit();
			session.flush();
			
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
		
		
	}
	public List<Order> list(int index){
	List<Order> orders=null;
		
		Session session = null;
		Transaction tx = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			
			Query query=session.createQuery("from Order where  customer_id = :id");
			query.setParameter("id",index);
			orders=query.list();
			
		
			tx.commit();
			session.flush();
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
		
		
	
		return orders;			
		
		
	}
	public Order getOrder(int index){
		
		Order order=null;
		Transaction tx = null;
		Session session = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("from Order where order_id= :id");
			query.setInteger("id",index);
		    order= (Order) query.uniqueResult();
		   
		 
			tx.commit();
			session.flush();
			
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
		
		
		return order;
	}
   
}
