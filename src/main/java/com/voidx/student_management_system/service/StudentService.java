package com.voidx.student_management_system.service;
import com.voidx.student_management_system.dao.StudentDao;
import com.voidx.student_management_system.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {

    @Autowired
    private  StudentDao studentDao;

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }
}