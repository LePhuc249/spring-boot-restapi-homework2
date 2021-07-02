package nashtech.phucldh.spring.service;

import java.util.List;

import nashtech.phucldh.spring.entity.Employee;


public interface  EmployeeDAO {
	
	public List<Employee> findAll();

	public Employee getEmployeeById(Integer theId);
	
	public Employee createEmployee(Employee theEmployee);
	
	public void updateEmployee(Employee theEmployee);
	
	public void deleteEmployee(Integer theId);
}
