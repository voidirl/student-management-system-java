package dao;

import model.Student;
import java.sql.Connection;
import util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {

    //Insert
    public void addStudent(Student student){
        String sql = "Insert into students(id,name,age,course) values(?,?,?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,student.getId());
            ps.setString(2,student.getName());
            ps.setInt(3,student.getAge());
            ps.setString(4,student.getCourse());

            ps.executeUpdate();
            System.out.println("Student inserted into database");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //Read
    public void getAllStudents(){
        String sql = "Select * from students";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                System.out.println(
                        "ID: "+rs.getInt("id")+
                                ",Name: "+rs.getString("name")+
                                ",Age: "+rs.getInt("age")+
                                ",Course: "+rs.getString("course")
                        );
            }
        }
         catch(Exception e){
            e.printStackTrace();
        }
    }

    //Update
    public void updateStudent(Student student){
        String sql = "Update students set name = ?,age = ?,course = ? where id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getCourse());
            ps.setInt(4,student.getId());

            int rows = ps.executeUpdate();

            if(rows>0){
                System.out.println("Student updated successfully");
            }else{
                System.out.println("Student not found with ID: "+student.getId());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //Delete
    public void deleteStudent(int id) {

        String sql = "delete from students where id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows>0) {
                System.out.println("Student deleted successfully");
            }
            else{
                System.out.println("Student not found with ID: "+id);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Search
    public void searchStudentById(int id) {
        String sql = "Select * from students where id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                ", Name: " + rs.getString("name") +
                                ", Age: " + rs.getInt("age") +
                                ", Course: " + rs.getString("course")
                );
            } else {
                System.out.println("Student not found with ID: "+id);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
