package com.register.conn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.register.entity.OnlineRegistration;

public class ConnectionHib extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("firstName");
		String lname=request.getParameter("lastName");
		String contact=request.getParameter("contactNumber");
		String address=request.getParameter("address");
		
		OnlineRegistration or=new OnlineRegistration();
		or.setFirstName(fname);
		or.setLastName(lname);
		or.setContactNumber(contact);
		or.setAddress(address);
		
       Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(OnlineRegistration.class);
        SessionFactory sessionFactory=con.buildSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(or);
		tx.commit();
		
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
        	String url="jdbc:mysql://localhost:3306/neon";
        	String uname="root";
        	String pass="root";
        	
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con1 = DriverManager.getConnection(url,uname,pass);
           
            Statement stmt = con1.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from neon.onlineregistration ");  
            out.println("<table border=1 >");  
            out.println("<tr><th>First Name</th><th>Last Name</th><th>Contact</th><th>Address</th><tr>");  
            while (rs.next()) 
            {  
                String f = rs.getString("firstName");  
                String l = rs.getString("lastName");  
                String c=rs.getString("contactNumber");
                String a=rs.getString("address");
                out.println("<tr><td>" + f + "</td><td>" + l + "</td><td>" + c +"</td><td>" + a +"</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con1.close();  
           }  
            catch (Exception e) 
           {  
            out.println(e.getMessage());  
           }
	}

}
