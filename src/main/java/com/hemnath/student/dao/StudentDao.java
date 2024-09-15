package com.hemnath.student.dao;

import com.hemnath.student.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection connection;

    public StudentDao() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public int deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Student findById(int id) {
        try {
            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String className = resultSet.getString("class");
                String email = resultSet.getString("email");

                return new Student(id, name, age, className, email);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getAllStudent() {
        try {
            String query = "select * from students";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("class"),
                        resultSet.getString("email")
                ));
            }
            return studentList;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
