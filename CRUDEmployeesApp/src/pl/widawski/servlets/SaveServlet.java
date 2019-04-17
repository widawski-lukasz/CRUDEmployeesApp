package pl.widawski.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.widawski.emp.Employee;

public class SaveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUDEmployeesApp");
		EntityManager em = emf.createEntityManager();
		Employee em1 = em.find(Employee.class, 1);
		res.getWriter().println(em1.getFirstName() + " " + em1.getLastName());
		em.close();
		emf.close();
//		PrintWriter pw = res.getWriter();
		
//		pw.println("<html><head><title>CRUD Employees App</title></head>");
//		pw.println("<body>");
//		pw.println("<form method=\"post\">");
//		pw.println("<p>Podaj</p><input name=\"name\" /><input type=\"submit\" value=\"OK\" />");
//		pw.println("</form>");
//		pw.println("</body></html>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		String name = req.getParameter("name");
		if (name != null && !"".equals(name))
			pw.println("Witaj, " + name);
	}
}
