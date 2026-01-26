import service.StudentService;
import model.Student;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n-- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student student = new Student(id,name,age,course);
                    service.addStudent(student);
                    break;

                case 2:
                    service.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int uage = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String ucourse = sc.nextLine();

                    Student updateStudent = new Student(uid,uname,uage,ucourse);
                    service.updateStudent(updateStudent);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    service.deleteStudent(did);
                    break;

                case 5:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    service.searchstudentById(sid);
                    break;

                case 6:
                    System.out.println("Exiting System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}