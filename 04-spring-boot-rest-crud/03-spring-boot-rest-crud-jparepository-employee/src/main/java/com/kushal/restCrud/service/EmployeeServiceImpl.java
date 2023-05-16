package com.kushal.restCrud.service;

import com.kushal.restCrud.dao.EmployeeRepository;
import com.kushal.restCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;
//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO dao){
//        employeeDAO = dao;
//    }
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repo){
        employeeRepository = repo;
}
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee emp = null;
        if(result.isPresent()){
            emp=result.get();
        }else{
            throw new RuntimeException("Did not find the employee id "+theId);
        }
        return emp;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
