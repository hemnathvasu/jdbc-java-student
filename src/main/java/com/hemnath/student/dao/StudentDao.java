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

    public int saveStudent(Student student) throws SQLException {

        String query = "INSERT INTO students (name, age, class, email ) VALUES (?, ?, ?, ?)";

        try {
            if (!validateStudent(student.getEmail())) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, student.getName());
                statement.setInt(2, student.getAge());
                statement.setString(3, student.getCls());
                statement.setString(4, student.getEmail());

                return statement.executeUpdate(); // returns number of rows affected
            } else {
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception to be handled by the calling method
        }
    }

    public int updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name = ?, age = ? ,class = ?,email = ? WHERE id = ?";
        try {
            if(validateStudent(student.getEmail())) {
                System.out.println("Check");
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, student.getName());
                stmt.setInt(2, student.getAge());
                stmt.setString(3,student.getCls());
                stmt.setString(4,student.getEmail());
                stmt.setInt(5,student.getId());
                return stmt.executeUpdate();
            }else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
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

    public boolean validateStudent(String email) {
        try {
            String query = "SELECT * FROM students WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
