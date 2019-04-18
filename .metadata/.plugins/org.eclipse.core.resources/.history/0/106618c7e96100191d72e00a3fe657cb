package pl.widawski.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.widawski.dao.EmployeeDAO;
import pl.widawski.emp.Employee;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = new Employee();
		
		String stringId = req.getParameter("id");
		int id = Integer.parseInt(stringId);
		emp.setId(id);
		emp.setFirstName(req.getParameter("fname"));
		emp.setLastName(req.getParameter("lname"));
		emp.setCountry(req.getParameter("country"));
		emp.setEmail( req.getParameter("email"));
		
		
		dao.update(emp);
		
		
		res.sendRedirect("view");
		
		
	}
}