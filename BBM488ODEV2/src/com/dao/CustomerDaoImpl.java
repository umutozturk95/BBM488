package com.dao;
import java.util.*;
import java.io.*;

import com.model.*;

import java.io.*;
import java.util.*;
public class CustomerDaoImpl  implements Dao{
	
	
    //private List<Customer> customers=new ArrayList<Customer>();
    //int control=0;
	
	public CustomerDaoImpl(){
		try{
			  FileOutputStream fout=new FileOutputStream("customer.txt");  
			  ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			  out.writeObject(new ArrayList<Customer>());  
			  out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
		
		
	}
	@Override
	public void add(Object o){
		List<Customer> customers;
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("customer.txt")); 
			 customers=(List<Customer>)in.readObject();
			 in.close();  
			 customers.add((Customer)o);
					 
			 FileOutputStream fout=new FileOutputStream("customer.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(customers);
			 out.flush();  
			 
			 
			
		}
		catch(Exception e){
			
		}
	}

	@Override
	public void delete(int index) {
		List<Customer> customers;
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("customer.txt")); 
			 customers=(List<Customer>)in.readObject();
			 in.close();  
			 customers.remove(index);
					 
			 FileOutputStream fout=new FileOutputStream("customer.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(customers);
			 out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		List<Customer> customers=null;
		try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("customer.txt")); 
			customers=(List<Customer>)in.readObject();
			in.close();  
		}
		catch(Exception e){
			
			
		}
		
		
		return customers;
		
		
		
	}

	@Override
	public void update(Object o,int index) {
		// TODO Auto-generated method stub
		Customer customer=(Customer)o;
		List<Customer> customers=null;
          try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("customer.txt")); 
			customers=(List<Customer>)in.readObject();		
			in.close();  
		    customers.set(index, customer);
				
			 
			 FileOutputStream fout=new FileOutputStream("customer.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(customers);
			 out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
	}
	public Customer getCustomer(int index){
		List<Customer> customers=null;
		Customer customer=null;
		try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("customer.txt")); 
			customers=(List<Customer>)in.readObject();
			customer=customers.get(index);
			in.close();  
			
		}
		catch(Exception e){
			
			
		}
		
		
		return customer;
	}
	

}
