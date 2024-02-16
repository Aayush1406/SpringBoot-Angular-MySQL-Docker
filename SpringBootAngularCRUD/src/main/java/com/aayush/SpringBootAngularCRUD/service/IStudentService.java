package com.aayush.SpringBootAngularCRUD.service;

import java.util.List;

import com.aayush.SpringBootAngularCRUD.model.Student;

public interface IStudentService {

	Integer saveStudent(Student s);
	void updateStudent(Student s);
	void deleteStudent(Integer id);
	Student getOneStudent(Integer id);
	List<Student> getAllStudents();
}
