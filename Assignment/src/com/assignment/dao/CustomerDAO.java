package com.assignment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.assignment.model.Customer;


//CRUD operations for the table customers
public class CustomerDAO {
	private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/assignment?userSSl=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "System54321@";
	
	private static final String InsertCustomer = "insert into t_customer" + "(fname,lname,email,address,city,state,zipcode,phone,mobile,birthday,phone2) values " + "(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String CustomerByID = "select customerID, fname, lname, email, address, city, state, zipcode, phone, mobile, birthday, phone2 from t_customer where customerID = ?";
	private static final String AllCustomers = "select * from t_customer";
	private static final String DeleteCustomer = "delete from t_customer where customerID = ?;";
	private static final String UpdateCustomer = "update t_customer set fname=?,lname =?,email=?,address=?,city=?,state=?,zipcode=?,phone=?,mobile=?,birthday=?,phone2=? where customerID=?;";
	
	protected Connection getconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//Insert Customer
	public void insertCustomer(Customer customer) throws SQLException {
		try(Connection connection = getconnection();
				PreparedStatement preparedStatement = connection.prepareStatement(InsertCustomer)){
			preparedStatement.setString(1, customer.getFname());
			preparedStatement.setString(2, customer.getLname());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getCity());
			preparedStatement.setString(6, customer.getState());
			preparedStatement.setString(7, customer.getZipcode());
			preparedStatement.setString(8, customer.getPhone());
			preparedStatement.setString(9, customer.getMobile());
			preparedStatement.setDate(10, customer.getBirthday());
			preparedStatement.setString(11, customer.getPhone2());
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Update Customer 
	public boolean updateCustomer(Customer customer) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getconnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UpdateCustomer);){
			preparedStatement.setString(1, customer.getFname());
			preparedStatement.setString(2, customer.getLname());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getCity());
			preparedStatement.setString(6, customer.getState());
			preparedStatement.setString(7, customer.getZipcode());
			preparedStatement.setString(8, customer.getPhone());
			preparedStatement.setString(9, customer.getMobile());
			preparedStatement.setDate(10, customer.getBirthday());
			preparedStatement.setString(11, customer.getPhone2());
			preparedStatement.setInt(12, customer.getId());
			
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//Select Customer by ID
	 public Customer selectCustomer(int customerID) {
		 Customer customer = null;
		 try (Connection connection = getconnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(CustomerByID);) {
			 preparedStatement.setInt(1, customerID);
			 System.out.println(preparedStatement);
			 
			 ResultSet rs = preparedStatement.executeQuery();
			 
			 while(rs.next()) {
				 String fname = rs.getString("fname");
				 String lname = rs.getString("lname");
				 String email = rs.getString("email");
				 String address = rs.getString("address");
				 String city = rs.getString("city");
				 String state = rs.getString("state");
				 String zipcode = rs.getString("zipcode");
				 String phone = rs.getString("phone");
				 String mobile = rs.getString("mobile");
				 Date birthday = rs.getDate("birthday");
				 String phone2 = rs.getString("phone2");
				 customer = new Customer(customerID, fname, lname, email, address, city, state, zipcode, phone, mobile, birthday, phone2);
			 }
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		return customer;	 
	 }
	
	//View Customers
	 public List<Customer> viewCustomers(){
		 List<Customer> customers = new ArrayList<>();
		 try(Connection connection = getconnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(AllCustomers);){
			 
			 ResultSet rs = preparedStatement.executeQuery();
			 
			 while(rs.next()) {
				 int customerID = rs.getInt("customerID");
				 String fname = rs.getString("fname");
				 String lname = rs.getString("lname");
				 String email = rs.getString("email");
				 String address = rs.getString("address");
				 String city = rs.getString("city");
				 String state = rs.getString("state");
				 String zipcode = rs.getString("zipcode");
				 String phone = rs.getString("phone");
				 String mobile = rs.getString("mobile");
				 Date birthday = rs.getDate("birthday");
				 String phone2 = rs.getString("phone2");
				 customers.add(new Customer(customerID, fname, lname, email, address, city, state, zipcode, phone, mobile, birthday, phone2));
			 } 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	 }
		
	//Delete Customer
	public boolean deleteCustomer(int customerID) throws SQLException {
		boolean rowDeleted;
		try(Connection connection = getconnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DeleteCustomer);){
			preparedStatement.setInt(1, customerID);
			
			rowDeleted = preparedStatement.executeUpdate() > 0;	
		}
		return rowDeleted;
	}

}
