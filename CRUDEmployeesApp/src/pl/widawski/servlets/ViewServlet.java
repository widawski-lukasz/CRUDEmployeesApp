package pl.widawski.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.widawski.dao.EmployeeDAO;
import pl.widawski.emp.Employee;

public class ViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter pw = res.getWriter();
		pw.println("<h1>Employees List</h1>");
		pw.println("<html><head><title>Employees List</title></head>");
		pw.println("<body>");
		pw.println("<tr><td><a href='index.jsp'><input type='button' value='Main page' /></a></td></tr>");
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empsList = dao.getEmps();
		pw.print("<table border='1' wodth='100%'");
		pw.print("<tr><th>id</th><th>First Name</th><th>Last Name</th><th>Country</th><th>Email</th><th>Edit</th><th>Delete</th>");
		for(Employee loop : empsList) {
			pw.println("<tr><th>"+loop.getId()+"</th><th>"+loop.getFirstName()+"</th><th>"+loop.getLastName()+"</th><th>"+loop.getCountry()+"</th><th>"+loop.getEmail()+"</th><th>Edit</th><th>Delete</th>");
		}
		pw.print("</table>");
		pw.println("</body></html>");
		
		
	}
}