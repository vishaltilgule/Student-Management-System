package com.example.SMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SMS.entity.Student;
import com.example.SMS.service.StudentService;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String listStudent(Model model) {
        model.addAttribute("student", studentService.getAllStudent());
        return "student";
    }

    @GetMapping("/student/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student";
    }
    
    @GetMapping("/student/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model) {
    	model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
    	
    }
    
    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model){
    		
    	Student existingStudent = studentService.getStudentById(id);
    	existingStudent.setId(id);
    	existingStudent.setFirstName(student.getFirstName());
    	existingStudent.setLastName(student.getLastName());
    	existingStudent.setEmail(student.getEmail());
    	
    	//save updated student object
    	studentService.updateStudent(existingStudent);
    	return "redirect:/student";
    	}
    
    //handle method to handle delete student request 
    @GetMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {
    	studentService.deleteStudentById(id);
    	return "redirect:/student";
    }
    }

