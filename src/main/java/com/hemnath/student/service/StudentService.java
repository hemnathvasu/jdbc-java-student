package com.hemnath.student.service;

import com.hemnath.student.dao.StudentDao;
import com.hemnath.student.model.Student;
import java.sql.SQLException;

public class StudentService {

    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudentById(int id) {
        try {
            return studentDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
