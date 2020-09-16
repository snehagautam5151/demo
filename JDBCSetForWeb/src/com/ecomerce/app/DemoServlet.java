package com.ecomerce.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecomerce.connection.DBConnection;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DBConnection = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		// get config

		InputStream ins = getServletContext().getResourceAsStream("/WEB-INF/config.Properties");
		Properties props = new Properties();

		props.load(ins);
		
		//create connection
		//create connection 
try {
		DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
		if(conn != null)
		    out.print("<h3> DBConnection intialised : </h3>");
		else
		    out.print("<h3> DBConnection intialised : </h3>");

		conn.closeconnection();
		 out.print("<h3> DBconnection closed: <h3>");
		}catch(ClassNotFoundException e) {
		e.printStackTrace();
		}catch(SQLException e) {
		e.printStackTrace();
		}


	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
		}
	

