package nashtech.phucldh.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nashtech.phucldh.spring.entity.Employee;
import nashtech.phucldh.spring.exception.EmployeeNotFoundException;
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
	public List<Employee> findAll() {
		List<Employee> customers = employeeResponsitory.findAll();
		return customers;
	}

	@Override
	public Employee getEmployeeById(Integer theId) {
		Optional<Employee> result  = employeeResponsitory.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result .get();
		} else {
			throw new EmployeeNotFoundException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	public Employee saveEmployee(Employee theEmployee) {
		return employeeResponsitory.save(theEmployee);
	}

	@Override
	public void deleteEmployee(Integer theId) {
		employeeResponsitory.deleteById(theId);
	}
	
	
}
