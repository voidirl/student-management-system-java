package service;

import dao.StudentDao;
import model.Student;

public class StudentService {

    private final StudentDao studentDao = new StudentDao();

    public void addStudent(Student student){
        studentDao.addStudent(student);
    }

    public void updateStudent(Student student){
        studentDao.updateStudent(student);
    }

    public void viewAllStudents(){
        studentDao.getAllStudents();
    }

    public void deleteStudent(int id){
        studentDao.deleteStudent(id);
    }

    public void searchstudentById(int id){
        studentDao.searchStudentById(id);
    }
}