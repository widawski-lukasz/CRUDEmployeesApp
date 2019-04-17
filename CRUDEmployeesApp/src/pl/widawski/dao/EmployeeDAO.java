package pl.widawski.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import pl.widawski.emp.Employee;

public class EmployeeDAO {
	private EntityManager em;
	private EntityTransaction et;
	public EmployeeDAO(){
		this.em = DBConfig.getEntityManagerFactory().createEntityManager();
		this.et = em.getTransaction();
	}
	public List<Employee> getEmps() {
		List<Employee> empsList = em.createQuery("Select e from Employee e").getResultList();
		return empsList;
	}
	public List<Employee> getTest() {
		List<Employee> empsList = em.createQuery("Select loop from Employee loop WHERE firstName='Tomek'").getResultList();
		return empsList;
	}
	public int deleteEmp(int id) {
		et.begin();
		try {
			int flag= id;
			em.createQuery("delete from Employee WHERE id="+flag).executeUpdate();
			et.commit();
		}catch(Throwable t) {
				et.rollback();
		}
		return id;
	}
}
