package Driver;

import java.util.List;

import Entity.Employee;
import Service.EmpService;

public class Driver {
	public static void main(String[] args) {
		
		EmpService empService=new EmpService();
		List<Employee> emps=empService.fetchAll();
		for (Employee employe : emps) {
			System.out.println(employe.getId()+": "+employe.getName()+": "+employe.getAge()+": "+employe.getEmailid()+": "+employe.getSalary());
		}
	}
}