import dao.StudentDao;
import model.Student;

public class Main{
    public static void main(String[] args){

        StudentDao dao = new StudentDao();

        Student s1 = new Student(1,"Rishav",20,"Btech");
        dao.addStudent(s1);
        dao.getAllStudents();

    }
}