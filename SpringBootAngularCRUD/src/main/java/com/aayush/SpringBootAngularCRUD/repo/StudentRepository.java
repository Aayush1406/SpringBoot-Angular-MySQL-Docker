package com.aayush.SpringBootAngularCRUD.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.SpringBootAngularCRUD.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
