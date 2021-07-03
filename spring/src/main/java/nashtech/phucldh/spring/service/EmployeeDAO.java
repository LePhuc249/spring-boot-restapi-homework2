package nashtech.phucldh.spring.service;

import java.util.List;

import nashtech.phucldh.spring.entity.Employee;


public interface  EmployeeDAO {
	
	public List<Employee> findAll();

	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
