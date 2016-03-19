package de.exp.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation via 
 * - extending HttpServlet
 * - annotating with javax.servlet.annotation.WebServlet  
 * 
 * Achtung: 
 * the last "/" is important. 
 * If you need this to react on any URL with the given prefix - use "*" 
 * @WebServlet("/servlet/DemoData1WebServlet/*"}
 * 
 * 
 */
@WebServlet({"/servlet/DemoData1WebServlet/","/servlet/DemoData1WebServlet"})
public class DemoData1WebServlet extends HttpServlet {

	private static final long serialVersionUID = -3556093635857011044L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Demo1 WebServlet: This one generates demo data on GET");
	}

}
