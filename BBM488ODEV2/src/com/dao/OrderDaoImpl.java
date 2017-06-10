package com.dao;
import java.util.*;
import java.io.*;

import com.model.*;
public class OrderDaoImpl  implements Dao{
    public OrderDaoImpl(){
    	try{
			  FileOutputStream fout=new FileOutputStream("order.txt");  
			  ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			  out.writeObject(new ArrayList<Order>());  
			  out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
    	
    }

	@Override
	public void add(Object o) {
		List<Order> orders;
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("order.txt")); 
			 orders=(List<Order>)in.readObject();
			 in.close();  
			 orders.add((Order)o);
					 
			 FileOutputStream fout=new FileOutputStream("order.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(orders);
			 out.flush();  
			 
			 
			
		}
		catch(Exception e){
			
		}
		
	}

	@Override
	public void delete(int index) {
		List<Order> orders;
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("order.txt")); 
			 orders=(List<Order>)in.readObject();
			 in.close();  
			 orders.remove(index);
					 
			 FileOutputStream fout=new FileOutputStream("order.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(orders);
			 out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
		
	}
	public void deleteDueToCustomer(String username) {
		List<Order> orders;
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("order.txt")); 
			 orders=(List<Order>)in.readObject();
			 in.close();  
			 for(int i=0;i<orders.size();i++){
				 if(orders.get(i).getUsername().equals(username)){
					 orders.remove(i);
					 i--;
				 }
				 
			 }
					 
			 FileOutputStream fout=new FileOutputStream("order.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(orders);
			 out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
		
	}
	public void deleteDueToProduct(String productname) {
		List<Order> orders;
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("order.txt")); 
			 orders=(List<Order>)in.readObject();
			 in.close();  
			 for(int i=0;i<orders.size();i++){
				 if(orders.get(i).getProductname().equals(productname)){
					 orders.remove(i);
					 i--;
				 }
				 
			 }
					 
			 FileOutputStream fout=new FileOutputStream("order.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(orders);
			 out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
	}
	@Override
	public Object list() {
		List<Order> orders=null;
		try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("order.txt")); 
			orders=(List<Order>)in.readObject();
			in.close();  
		}
		catch(Exception e){
			
			
		}
		
		return orders;				
	}

	@Override
	public void update(Object o,int index) {
		Order order=(Order)o;
		List<Order> orders=null;
          try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("order.txt")); 
			orders=(List<Order>)in.readObject();		
			in.close();  
		    orders.set(index, order);
				
			 
			 FileOutputStream fout=new FileOutputStream("order.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(orders);
			 out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
	}
	public List<Order> list(String username){
		List<Order> orders;
		List<Order> ordersRelatedToUser=new ArrayList<Order>();
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("order.txt")); 
			 orders=(List<Order>)in.readObject();
			 in.close();  
			
			 for(int i=0;i<orders.size();i++){
				 if(orders.get(i).getUsername().equals(username)){
					 ordersRelatedToUser.add(orders.get(i));
					 
				 }
				 
			 }
					 			
		}
		catch(Exception e){
			
			
		}
		
		return ordersRelatedToUser;
	}
	public Order getOrder(int index){
		List<Order> orders=null;
		Order order=null;
		try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("order.txt")); 
			orders=(List<Order>)in.readObject();
			order=orders.get(index);
			in.close();  
			
		}
		catch(Exception e){
			
			
		}
		
		
		return order;
	}
   
}
