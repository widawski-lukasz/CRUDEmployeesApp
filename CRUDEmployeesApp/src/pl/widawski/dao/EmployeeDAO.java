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
	
	public Employee getEmployee(int id) {
		try {
			int flag = id;
			List<Employee> empL = em.createQuery("select e FROM Employee e where id="+flag).getResultList();
			return empL.get(0);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int update(Employee emp) {
		int flag = emp.getId();
		et.begin();
		try {
			em.createQuery("UPDATE Employee e set e.email='"+emp.getEmail()+"',e.country='"+emp.getCountry()+"',e.firstName='"+emp.getFirstName()+"',e.lastName='"+emp.getLastName()+"' where e.id ="+flag).executeUpdate();
			System.out.println("done");
			//em.merge(emp);
			et.commit();
		}catch(Throwable t) {
				et.rollback();
		}
		return flag;
	}
	
	public String saveEmp(Employee emp) {
		et.begin();
		String done = "";
		try {	
			em.persist(emp);
			et.commit();
			done = "Employee: "+ emp.getFirstName()+" "+ emp.getLastName()+ " added.";
			System.out.println(done);
		}catch(Throwable t) {
				et.rollback();
		}
		return done;
	}

	
}
