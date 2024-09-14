package com.hemnath.student.dao;
import com.hemnath.student.model.Student;
import java.sql.*;

public class StudentDao {
    private Connection connection;

    public StudentDao (){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Student findById(int id) throws SQLException {
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
    }
}
