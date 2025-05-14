package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Employee;
import jsp.springboot.service.EmployeeService;

@RestController
@RequestMapping("/jsp/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// insert a record
	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	// fetch all record
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	// fetch by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}

	// update a record
	@PutMapping
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployee(@PathVariable Integer id) {
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/role/{role}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByRole(@PathVariable String role) {
		return employeeService.getEmployeeByRole(role);
	}
	
	@GetMapping("/{pageNumber}/{pageSize}")
	public ResponseEntity<ResponseStructure<Page<Employee>>> getEmployeeWithPagination(@PathVariable int pageNumber, @PathVariable int pageSize) {
		return employeeService.getEmployeeWithPagination(pageNumber, pageSize);
	}
	
	@GetMapping("/sort/{field}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeBySorting(@PathVariable String field) {
		return employeeService.getEmployeeBySorting(field);
	}
	
	@GetMapping("/{pageNumber}/{pageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Employee>>> getEmployeeByPaginationAndSorting(@PathVariable int pageNumber, @PathVariable int pageSize, @PathVariable String field){
		return employeeService.getEmployeeByPaginationAndSorting(pageNumber, pageSize, field);
	}
	
	
	
	
}
