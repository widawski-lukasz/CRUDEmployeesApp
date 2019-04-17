package pl.widawski.dao;

import java.util.List;

import javax.persistence.EntityManager;

import pl.widawski.emp.Employee;

public class EmployeeDAO {
	private EntityManager em;
	public EmployeeDAO(){
		this.em = DBConfig.getEntityManagerFactory().createEntityManager();
	}
	public List<Employee> getEmps() {
		List<Employee> empsList = em.createQuery("Select loop from Employee loop").getResultList();
		return empsList;
	}
	public List<Employee> getTest() {
		List<Employee> empsList = em.createQuery("Select loop from Employee loop WHERE firstName='Tomek'").getResultList();
		return empsList;
	}
	
}