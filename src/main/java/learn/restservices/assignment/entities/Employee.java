package learn.restservices.assignment.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

//JsonView Assignment
public class Employee {

	@JsonView(View.NormalView.class)
	private Long empId;
	@JsonView(View.NormalView.class)
	private String name;
	@JsonView(View.NormalView.class)
	private String department;
	@JsonView(View.ManagerView.class)
	private LocalDateTime logInTime;
	@JsonView(View.ManagerView.class)
	private LocalDateTime logOutTime;
	@JsonView(View.HRView.class)
	private Double salary;
	@JsonView(View.HRView.class)
	private LocalDate lastPromotionDate;

	public Employee(Long empId, String name, String department, LocalDateTime logInTime, LocalDateTime logOutTime,
			Double salary, LocalDate lastPromotionDate) {
		super();
		this.empId = empId;
		this.name = name;
		this.department = department;
		this.logInTime = logInTime;
		this.logOutTime = logOutTime;
		this.salary = salary;
		this.lastPromotionDate = lastPromotionDate;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDateTime getLogInTime() {
		return logInTime;
	}

	public void setLogInTime(LocalDateTime logInTime) {
		this.logInTime = logInTime;
	}

	public LocalDateTime getLogOutTime() {
		return logOutTime;
	}

	public void setLogOutTime(LocalDateTime logOutTime) {
		this.logOutTime = logOutTime;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getLastPromotionDate() {
		return lastPromotionDate;
	}

	public void setLastPromotionDate(LocalDate lastPromotionDate) {
		this.lastPromotionDate = lastPromotionDate;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", department=" + department + ", logInTime=" + logInTime
				+ ", logOutTime=" + logOutTime + ", salary=" + salary + ", lastPromotionDate=" + lastPromotionDate
				+ "]";
	}

}
