package fruit.demo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import fruit.demo.dao.EmployeeDao;
import fruit.demo.entity.Employee;

@ManagedBean
@ApplicationScoped
public class EmployeeBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//private static Logger log = Logger.getLogger(EmployeeBean.class);
	
	//private long employeeId;
	private Employee employee = new Employee();
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private String employeeName;
	private Date employeeHireDate;
	private double employeeSalary;		
	private List<Employee> listEmployee;
	
	
	@PostConstruct
	public void init() {
		listEmployee = getAllEmployees();
	}
	

	
	public List<Employee> getListEmployee() {
		return listEmployee;
	}
	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}
	/*public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}*/
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getEmployeeHireDate() {
		return employeeHireDate;
	}
	public void setEmployeeHireDate(Date employeeHireDate) {
		this.employeeHireDate = employeeHireDate;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}	
	
	public void saveEmployee() {
        
        EmployeeDao dao = new EmployeeDao();
        dao.addEmpployee(this.employee);       
        clearAll();
    }
	
	public void updateEmployee() {        
		EmployeeDao dao = new EmployeeDao();
        dao.updateCustomer(this);       
        clearAll();
    }
    public void deleteEmployee(int id) {
    	EmployeeDao dao = new EmployeeDao();
        dao.deleteEmployee(id);        
        clearAll();
    }
 
    public List<Employee> getAllEmployees() {
        List<Employee> emp = new ArrayList<Employee>();
        EmployeeDao dao = new EmployeeDao();
        emp = dao.getAllEmployees();
        
        return emp;
    }
	
    private void clearAll() {
        this.employeeName = "";
        this.employeeHireDate = null;
        this.employeeSalary = 0;   
    }
	

}
