package com.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.FormParam;  
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dao.CustomerDaoImpl;
import com.dao.OrderDaoImpl;
import com.dao.ProductDaoImpl;
import com.model.Customer;
import com.model.Order;
import com.model.Product;

import javax.ws.rs.PathParam; 
import javax.ws.rs.core.Response;  
@Path("/orders")
public class RwsController {
 private OrderDaoImpl orderDao;
 private CustomerDaoImpl customerDao;
 private ProductDaoImpl productDao;
	
	public RwsController(){
		orderDao=new OrderDaoImpl();
		customerDao=new CustomerDaoImpl();
		productDao=new ProductDaoImpl();
	

	}
	
	
	 @GET
	 @Produces({ MediaType.APPLICATION_XML})
	 public Response insertOrderWithParameters(@QueryParam("product_id")int product_id,@QueryParam("count")int count,@QueryParam("customer_id")int customer_id){
		 
		 Customer customer=customerDao.getCustomer(customer_id);
		 Product product=productDao.getProduct(product_id);
		 Order newOrder=new Order();
		 newOrder.setCustomer(customer);
		 newOrder.setProduct(product);
		 newOrder.setNumberOfProduct(String.valueOf(count));
		 newOrder.setOrderState("New");
		 orderDao.add(newOrder);
		 return Response.status(200).entity("The order is persisted into DBMS!").build();
		 
	 }
	 
	
	
	 @GET
	 @Path("/{product_id}/{count}/{customer_id}")
	 @Produces({ MediaType.APPLICATION_XML})
	 public Response insertOrderWithPath(@PathParam("product_id")int product_id,@PathParam("count")int count,@PathParam("customer_id")int customer_id){
		 
		 Customer customer=customerDao.getCustomer(customer_id);
		 Product product=productDao.getProduct(product_id);
		 Order newOrder=new Order();
		 newOrder.setCustomer(customer);
		 newOrder.setProduct(product);
		 newOrder.setNumberOfProduct(String.valueOf(count));
		 newOrder.setOrderState("New");
		 orderDao.add(newOrder);
		 return Response.status(200).entity("The order is persisted into DBMS!").build();
		 
	 }
	 
	 
	 @POST
	 @Path("/{customer_id}")
	 @Produces(MediaType.APPLICATION_XML)
	 public List<Order> getOrdersWithPath(@PathParam("customer_id")int customer_id)
	 {
		 List<Order>order=orderDao.list(customer_id);	  
		  return order;
	 }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_XML)
	 public List<Order> getOrdersWithParameters(@QueryParam("customer_id")int customer_id)
	 {
		 List<Order>order=orderDao.list(customer_id);	  
		  return order;
	 }
	 
	 
	 /*
	 @GET  
	 @Produces(MediaType.TEXT_HTML)  
	  public String sayHtmlHello() {  
	    return "<html> " + "<title>" + "Hello Jersey" + "</title>"  
	        + "<body><h1>" + "Hello Jersey HTML" + "</h1></body>" + "</html> ";  
	  }  
   */
 }
