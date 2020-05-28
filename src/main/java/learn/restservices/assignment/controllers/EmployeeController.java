package learn.restservices.assignment.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import learn.restservices.assignment.entities.Employee;
import learn.restservices.assignment.entities.View;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@JsonView(View.NormalView.class)
	@GetMapping
	public List<Employee> getAllEmployee() {
		Employee employee = new Employee(Long.valueOf(101), "john", "IT", LocalDateTime.now().minusHours(8),
				LocalDateTime.now(), Double.valueOf(1000000), LocalDate.now().minusYears(1));

		return Arrays.asList(employee);
	}

	@JsonView(View.HRView.class)
	@GetMapping("/hr")
	public List<Employee> getAllEmployee2() {
		Employee employee = new Employee(Long.valueOf(101), "john", "IT", LocalDateTime.now().minusHours(8),
				LocalDateTime.now(), Double.valueOf(1000000), LocalDate.now().minusYears(1));

		return Arrays.asList(employee);
	}

	@JsonView(View.ManagerView.class)
	@GetMapping("/manager")
	public List<Employee> getAllEmployee3() {
		Employee employee = new Employee(Long.valueOf(101), "john", "IT", LocalDateTime.now().minusHours(8),
				LocalDateTime.now(), Double.valueOf(1000000), LocalDate.now().minusYears(1));

		return Arrays.asList(employee);
	}

}
