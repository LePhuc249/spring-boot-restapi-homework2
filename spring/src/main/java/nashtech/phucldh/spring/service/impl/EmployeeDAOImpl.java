package nashtech.phucldh.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nashtech.phucldh.spring.entity.Employee;
import nashtech.phucldh.spring.responsitory.EmployeeResponsitory;
import nashtech.phucldh.spring.service.EmployeeDAO;

@Service
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private EmployeeResponsitory employeeResponsitory;
	
	@Autowired
	public EmployeeDAOImpl(EmployeeResponsitory theEmployeeResponsitory) {
		employeeResponsitory = theEmployeeResponsitory;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		List<Employee> customers = employeeResponsitory.findAll();
		return customers;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(Integer theId) {
		Optional<Employee> theCustomer = employeeResponsitory.findById(theId);
		return theCustomer.get();
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee theEmployee) {
		return employeeResponsitory.save(theEmployee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee theEmployee) {
		employeeResponsitory.saveAndFlush(theEmployee);
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer theId) {
		employeeResponsitory.deleteById(theId);
	}
	
	
}
