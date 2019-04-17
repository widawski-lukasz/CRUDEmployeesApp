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
public class SaveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUDEmployeesApp");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			Employee em3 = new Employee();
			em3.setCountry("POLAND");
			em3.setEmail("piotr@o2.pl");
			em3.setFirstName("Piotr");
			em3.setLastName("Nowak");
			
			
			em.persist(em3);
			et.commit();
		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
		}
		
		
		
		Employee em1 = em.find(Employee.class, 1);
		res.getWriter().println(em1.getFirstName() + " " + em1.getLastName());
		em.close();
		emf.close();
		
		
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empsList = dao.getEmps();
		for (Employee loop : empsList) {
			res.getWriter().println(loop.getFirstName());
		}
		
		List<Employee> testList = dao.getTest();
		for (Employee loop : testList) {
			res.getWriter().println("A tutaj test:");
			res.getWriter().println(loop.getFirstName());
		}
		
		
		
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
