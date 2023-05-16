package com.mcfly.crud_demo.dao;

import com.mcfly.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
