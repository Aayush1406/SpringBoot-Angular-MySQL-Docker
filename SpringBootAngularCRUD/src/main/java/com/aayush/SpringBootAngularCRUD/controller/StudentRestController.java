package com.aayush.SpringBootAngularCRUD.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aayush.SpringBootAngularCRUD.model.Student;
import com.aayush.SpringBootAngularCRUD.service.IStudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins="http://localhost:4200")
public class StudentRestController {

	@Autowired
	private IStudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) throws JsonProcessingException {
		
		Integer id = service.saveStudent(student);
		String body = "Student saved with Id "+id;
		System.out.println("called !!"+student.getStdName());
		return ResponseEntity.ok(body);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent(){
	
		List<Student> list = service.getAllStudents();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable Integer id){
	
		Student s = service.getOneStudent(id);		
	    return ResponseEntity.ok(s);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		
		service.deleteStudent(id);
		String msg = "Student Deleted"+id;
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Student student){
		Student fetchStudent = service.getOneStudent(student.getStdId());
		fetchStudent.setStdName(student.getStdName());
		fetchStudent.setStdCourse(student.getStdCourse());
		fetchStudent.setStdFee(student.getStdFee());
		fetchStudent.setStdId(student.getStdId());

		service.updateStudent(fetchStudent);
		String msg = "Student Updated"+student.getStdId();
		return ResponseEntity.ok(msg);
	}

}
