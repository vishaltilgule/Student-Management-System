package com.example.SMS.service;

import java.util.List;

import com.example.SMS.entity.Student;

public interface StudentService {
	List <Student> getAllStudent();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
