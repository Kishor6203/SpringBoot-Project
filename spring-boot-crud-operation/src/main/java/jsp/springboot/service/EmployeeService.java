package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springboot.dao.EmployeeDao;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Employee;
import jsp.springboot.exception.IdNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		Employee savedEmployee = employeeDao.saveEmployee(employee);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(savedEmployee);

		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee() {
		List<Employee> employees = employeeDao.getAllEmployee();

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (!employees.isEmpty()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(employees);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		} else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Failure");

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(Integer id) {

		Optional<Employee> opt = employeeDao.getEmployeeById(id);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee) {
		Employee updatedEmployee = employeeDao.saveEmployee(employee);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(updatedEmployee);

		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteEmployee(Integer id) {

		Optional<Employee> opt = employeeDao.getEmployeeById(id);

		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (opt.isPresent()) {
			employeeDao.deleteEmployee(opt.get());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData("Record deleted");

			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByRole(String role) {
		List<Employee> employees = employeeDao.getEmployeeByRole(role);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (!employees.isEmpty()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(employees);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		} else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Failure");

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Page<Employee>>> getEmployeeWithPagination(int pageNumber, int pageSize) {
		Page<Employee> page = employeeDao.getEmployeeWithPagination(pageNumber, pageSize);
		
		ResponseStructure<Page<Employee>> structure = new ResponseStructure<Page<Employee>>();
		if (!page.isEmpty()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(page);

			return new ResponseEntity<ResponseStructure<Page<Employee>>>(structure, HttpStatus.OK);
		} else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Failure");

			return new ResponseEntity<ResponseStructure<Page<Employee>>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeBySorting(String field) {
		List<Employee> employees = employeeDao.getEmployeeWithSorting(field);
		
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		
		if (!employees.isEmpty()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(employees);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		} else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Failure");

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Page<Employee>>> getEmployeeByPaginationAndSorting(int pageNumber, int pageSize, String field) {
Page<Employee> page = employeeDao.getEmployeeByPaginationAndSorting(pageNumber, pageSize, field);
		
		ResponseStructure<Page<Employee>> structure = new ResponseStructure<Page<Employee>>();
		if (!page.isEmpty()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(page);

			return new ResponseEntity<ResponseStructure<Page<Employee>>>(structure, HttpStatus.OK);
		} else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Failure");

			return new ResponseEntity<ResponseStructure<Page<Employee>>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
}
