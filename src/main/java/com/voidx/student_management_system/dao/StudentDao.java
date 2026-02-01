package com.voidx.student_management_system.dao;

import com.voidx.student_management_system.model.Student;
import com.voidx.student_management_system.util.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    public void addStudent(Student student) {
        String sql = "insert into students(id, name, age, course) values (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getCourse());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        String sql = "select * from students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                );
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public void deleteStudent(int id) {
        String sql = "Delete from students where id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateStudent(int id,Student student){
        String sql = "Update students set name = ?,age = ?,course = ? where id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getCourse());
            ps.setInt(4,id);

            ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
