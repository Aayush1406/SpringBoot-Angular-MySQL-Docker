package com.aayush.SpringBootAngularCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aayush.SpringBootAngularCRUD.model.Student;
import com.aayush.SpringBootAngularCRUD.repo.StudentRepository;
import com.aayush.SpringBootAngularCRUD.util.StudentUtil;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	@Autowired 
	private StudentUtil stdUtil;
	
	@Override
	public Integer saveStudent(Student s) {
		stdUtil.calculateDetails(s);
		s = repo.save(s);
		return s.getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		stdUtil.calculateDetails(s);
		repo.save(s);
	}

	@Override
	public void deleteStudent(Integer id) {
	
		repo.deleteById(id);
		
	}

	@Override
	public Student getOneStudent(Integer id) {
		Optional<Student> opt =  repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

}
