package fruit.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import fruit.demo.bean.EmployeeBean;
import fruit.demo.entity.Employee;
import fruit.demo.hibernateUtils.HibernateUtils;

public class EmployeeDao {

	public void addEmpployee(Employee employee) {
		Transaction trns = null;
		/*Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();

		} catch (Exception e) {
			if (trns != null)
				trns.rollback();
			e.printStackTrace();
		} finally {
			// session.flush();
			session.close();
		}*/
	}

	public void deleteEmployee(int id) {
		Transaction trns = null;
		/*Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Employee cust = (Employee) session.load(Employee.class, new Integer(id));
			session.delete(cust);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}*/
	}

	public void updateCustomer(EmployeeBean employeeBean) {
		Transaction trns = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(employeeBean);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public List<Employee> getAllEmployees() {		
	        List<Employee> emp = new ArrayList<Employee>();
	        Transaction trns = null;
	        Session session = HibernateUtils.getSessionFactory().openSession();	
	        
	        try {
	        	
	        	trns=session.beginTransaction();	        	
	        	System.out.println("trai test");
	        	
	        } catch (RuntimeException e) {
	        	e.getMessage();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        
	        return emp;
	    
	    }
}
