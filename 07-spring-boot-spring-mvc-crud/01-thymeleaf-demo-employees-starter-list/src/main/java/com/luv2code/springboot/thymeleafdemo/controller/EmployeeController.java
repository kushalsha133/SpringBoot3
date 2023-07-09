package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	public EmployeeController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		employeeService.save(theEmployee);
		/*this is called post redirect get pattern i.e. are not responding back to the user with the same page we redirect
		* them to a different page. WHY? users can refresh a page which results to resubmitting a POST request and that might
		* lead to duplicate entries in DB
		* */
		return "redirect:/employees/list";
	}


	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
		//Get the employee
		Employee theEmployee = employeeService.findById(theId);
		//adding this object to prepopulate the update form with existing info
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}

	@GetMapping("/delete")
	public String deleteById(@RequestParam("employeeId") int theId, Model theModel){
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}
}









