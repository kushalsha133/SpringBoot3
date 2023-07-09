package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

    //adding method to sort by last Name
    //JPA repository will create a query on its own by reading the method name, so the method name has to follow a patter
    // findAllBy -OrderByLastName- Asc
    public List<Employee> findAllByOrderByLastNameAsc();
}
