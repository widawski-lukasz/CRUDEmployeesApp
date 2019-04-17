package pl.widawski.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.widawski.dao.EmployeeDAO;

public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter pw = res.getWriter();
		EmployeeDAO dao = new EmployeeDAO();
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		String deletedCom = ("User with id: " + dao.deleteEmp(id) + " deleted.");
		System.out.println(deletedCom);
		
		res.sendRedirect("view");
		
		
	}
}