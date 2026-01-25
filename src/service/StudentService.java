package service;

import dao.StudentDao;
import model.Student;

public class StudentService {

    private final StudentDao studentDao = new StudentDao();

    public void addStudent(Student student){
        studentDao.addStudent(student);
    }
    public void viewAllStudents(){
        studentDao.getAllStudents();
    }
}