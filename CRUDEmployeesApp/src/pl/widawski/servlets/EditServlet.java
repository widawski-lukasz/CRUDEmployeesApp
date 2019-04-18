package pl.widawski.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.widawski.dao.EmployeeDAO;
import pl.widawski.emp.Employee;

public class EditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter pw = res.getWriter();
		pw.println("<h1>Edit employee</h1>");
		pw.println("<html><head><title>CRUD EmpApp</title></head>");
		pw.println("<body>");
	
		String stringId = req.getParameter("id");
		int id = Integer.parseInt(stringId);
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = dao.getEmployee(id);
		
		pw.print("<form action='update' method='get'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
		pw.print("<tr><td>First name:</td><td><input type='text' name='fname' value='"+e.getFirstName()+"'/></td></tr>");
		pw.print("<tr><td>Last name:</td><td><input type='text' name='lname' value='"+e.getLastName()+"'/></td></tr>");
		pw.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>");
		pw.print("<tr><td>Country:</td><td><select name='country' style='width:150px'>");
		pw.print("<option>POLAND</option>");
		pw.print("<option>USA</option>");
		pw.print("<option>GERMANY</option>");
		pw.print("<option>OTHER</option>");
		pw.print("</select>");
		pw.print("</td></tr>");
		pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
		pw.print("</table>");
		pw.print("</form>");
	}
}