package com.example.erecruit.service;

import com.example.erecruit.model.Student;
import com.example.erecruit.db.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudent() {
        return studentRepository.findTopByOrderByIdDesc();
    }
    public void addStudentForm(Student student) {
        studentRepository.save(student);
    }
}
