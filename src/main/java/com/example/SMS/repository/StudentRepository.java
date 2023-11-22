  package com.example.SMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SMS.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
