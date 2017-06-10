package com.dao;
import java.util.*;
import java.io.*;

import com.model.Customer;
import com.model.Product;
public class ProductDaoImpl implements Dao {
    
	
	public ProductDaoImpl(){
		try{
			  FileOutputStream fout=new FileOutputStream("product.txt");  
			  ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			  out.writeObject(new ArrayList<Product>());  
			  out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
		
	}
	
	
	
	@Override
	public void add(Object o) {
		List<Product> products;
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("product.txt")); 
			 products=(List<Product>)in.readObject();
			 in.close();  
			 products.add((Product)o);
					 
			 FileOutputStream fout=new FileOutputStream("product.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(products);
			 out.flush();  
			 
			 
			
		}
		catch(Exception e){
			
		}
		
	}

	@Override
	public void delete(int index) {
		List<Product> products;
		try{
			
			 ObjectInputStream in=new ObjectInputStream(new FileInputStream("product.txt")); 
			 products=(List<Product>)in.readObject();
			 in.close();  
			 products.remove(index);
					 
			 FileOutputStream fout=new FileOutputStream("product.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(products);
			 out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
		
		
	}

	@Override
	public Object list() {
		List<Product> products=null;
		try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("product.txt")); 
			products=(List<Product>)in.readObject();
			in.close();  
		}
		catch(Exception e){
			
			
		}
		return products;
	}

	@Override
	public void update(Object o, int index) {
		Product product=(Product)o;
		List<Product> products=null;
          try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("product.txt")); 
			products=(List<Product>)in.readObject();		
			in.close();  
		    products.set(index, product);
				
			 
			 FileOutputStream fout=new FileOutputStream("product.txt");  
			 ObjectOutputStream out=new ObjectOutputStream(fout);  
			  
			 out.writeObject(products);
			 out.flush();  
			
		}
		catch(Exception e){
			
			
		}
		
		
	}
	public Product getProduct(int index){
		List<Product> products=null;
		Product product=null;
		try{
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("product.txt")); 
			products=(List<Product>)in.readObject();
			product=products.get(index);
			in.close();  
			
		}
		catch(Exception e){
				
		}
		return product;
	}

}
