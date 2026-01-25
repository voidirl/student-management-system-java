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
            System.out.println("3. Exit");
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
                    System.out.println("Exiting system....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}