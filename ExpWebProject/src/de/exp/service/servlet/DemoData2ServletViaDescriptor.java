package de.exp.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation via extending HttpServlet. You have to : - extend
 * HttpServlet - in web.xml define the "servlet" - in web.xml define the
 * "servlet-mapping"
 * 
 * Achtung: - the definition of Application by extending
 * javax.ws.rs.core.Application will not influence the @ApplicationPath by prepending its
 * "jaxrs" to this HttpServlet. javax.ws.rs.core.Application @ApplicationPath only influences
 * the Servlets defined by annotations 
 * 
 */
public class DemoData2ServletViaDescriptor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Demo2 HttpServlet: This one generates demo data on GET");
		out.println("Served at: "+request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("Demo2 HttpServlet: This one generates demo data on POST");
	}
}
