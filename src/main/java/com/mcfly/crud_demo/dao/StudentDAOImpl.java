package com.mcfly.crud_demo.dao;

import com.mcfly.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository annotation additionally translates checked db exceptions into unchecked exceptions to make development process more convenient.
@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    // @Autowired annotation is optional in case there is only a single constructor.
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Db update should be @Transactional.
    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        final TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        final TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        query.setParameter("theData", theLastName);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        final Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Transactional
    @Override
    public int deleteAll() {
        final TypedQuery<Student> query = entityManager.createQuery("delete from Student", Student.class);
        return query.executeUpdate();
    }
}
