package com.kushal.restCrud.dao;

import com.kushal.restCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> empList= query.getResultList();
        return empList;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = entityManager.merge(theEmployee);
        return employee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
