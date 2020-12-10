package com.assignment.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.dao.CustomerDAO;
import com.assignment.model.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerdao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
    	this.customerdao = new CustomerDAO(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertCustomer(request, response);
                    break;
                case "/delete":
                    deleteCustomer(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCustomer(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        Customer existingCustomer = customerdao.selectCustomer(customerID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);

    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String phone = request.getParameter("phone");
        String mobile = request.getParameter("mobile");
        Date birthday = Date.valueOf(request.getParameter("birthday")); 
        String phone2 = request.getParameter("phone2");
        Customer newCustomer = new Customer(fname, lname, email, address, city, state, zipcode, phone, mobile, birthday, phone2);
        customerdao.insertCustomer(newCustomer);
        response.sendRedirect("list");
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	int customerID = Integer.parseInt(request.getParameter("customerID"));
    	String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String phone = request.getParameter("phone");
        String mobile = request.getParameter("mobile");
        Date birthday = Date.valueOf(request.getParameter("birthday")); 
        String phone2 = request.getParameter("phone2");

        Customer updatecust = new Customer(customerID, fname, lname, email, address, city, state, zipcode, phone, mobile, birthday, phone2);
        customerdao.updateCustomer(updatecust);
        response.sendRedirect("list");
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        customerdao.deleteCustomer(customerID);
        response.sendRedirect("list");

    }
    
	private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Customer> listCustomer = customerdao.viewCustomers();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);

	}

}
