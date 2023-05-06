package com.kushal.SringCrud.dao;

import com.kushal.SringCrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //Entity Manager
    private EntityManager entityManager;


    //Entity Manager is autowired inherently by spring boot
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("From Student order by lastName", Student.class);
        List<Student> stuList = query.getResultList();
        return stuList;
    }

    @Override
    public List<Student> findByLastName(String lName) {
        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName=:lName", Student.class);
        query.setParameter("lName", lName);
        List<Student> stuList = query.getResultList();
        return stuList;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class , id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numROwsDeleted = entityManager.createQuery("Delete From Student").executeUpdate();
        return numROwsDeleted;
    }
}
