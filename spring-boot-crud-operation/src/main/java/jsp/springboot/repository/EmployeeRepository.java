package jsp.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//fetch employee based on role
	List<Employee> findByRole(String name);
	
	//fetch employee based on name and contact
	Optional<Employee> findByNameAndContact(String name, Long contact);
	
	//fetch employee where salary is greater than
	List<Employee> findBySalaryGreaterThan(Double salary);
	
	//fetch employee based on contact
	@Query("select e from Employee e where e.contact=87654324")
	Optional<Employee> getEmployeeByContact();
	
	//fetch employee based on name and salary
	@Query("select e from Employee e where e.name=?1 and e.salary=?2")
	List<Employee> getEmployeeByNameAndSalary(String name, Double salary);
	
	//fetch employee based on department
	@Query("select e from Employee e where e.department=:department")
	List<Employee> getEmployeeByDepartment(String department);
}
