package com.voidx.student_management_system.controller;

import com.voidx.student_management_system.model.Student;
import com.voidx.student_management_system.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id,
                              @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }
}
