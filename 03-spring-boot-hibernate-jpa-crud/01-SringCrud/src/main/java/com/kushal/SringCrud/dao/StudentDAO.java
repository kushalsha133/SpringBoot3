package com.kushal.SringCrud.dao;

import com.kushal.SringCrud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lName);
    void update(Student student);
    void delete(Integer id);

    int deleteAll();

}
