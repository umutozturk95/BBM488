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

import com.model.Customer;
import com.model.Product;
public class ProductDaoImpl implements Dao {
    
	 private  SessionFactory sessionFactory;
	public ProductDaoImpl(){
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
		Product product=(Product)o;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(product);
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
			
			Query query=session.createQuery("delete Order where  product_id= :id");
			query.setInteger("id",index);
		    int result=query.executeUpdate();
			
		    query=session.createQuery("delete Product where  product_id= :id");
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
		List<Product> products=null;
		Session session = null;
		Transaction tx = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			
			products=session.createQuery("from Product").list();
			
		
			tx.commit();
			session.flush();
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
		
		return products;
	}

	@Override
	public void update(Object o, int index) {
		Session session = null;
		Transaction tx = null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
		   Product product=(Product)o;	
		   session.saveOrUpdate(product);
			

			tx.commit();
			session.flush();
			
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
		
		
	}
	public Product getProduct(int index){
		Session session = null;
		Transaction tx = null;
		Product product=null;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("from Product where product_id= :id");
			query.setInteger("id",index);
		    product= (Product) query.uniqueResult();
		   
		  

			tx.commit();
			session.flush();
			
			
		}
		catch(Exception e){
			
			
		}
		finally{
			
			session.close();
		}
        return	product;
	}

}
