package com.hemnath.student.service;

import com.hemnath.student.dao.StudentDao;
import com.hemnath.student.model.Response;
import com.hemnath.student.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Response<Student> getStudent(int id) {
        Student student = studentDao.findById(id);

        if (student != null) {
            return new Response<>(200, "Student found", student);
        } else {
            return new Response<>(404, "Student not found", null);
        }
    }

    public Response<List<Student>> getAllStudent() {
        List<Student> studentList = studentDao.getAllStudent();

        if (studentList != null) {
            return new Response<>(200, "Student found", studentList);
        } else {
            return new Response<>(404, "Student not found", null);
        }
    }

    public Response<Student> removeStudent(int id) {
        int result = studentDao.deleteStudent(id);
        if (result == 1) {
            return new Response<>(200, "Successfully deleted", null);
        } else {
            return new Response<>(400, "Not existed", null);
        }

    }

    public Response<Student> insertStudent(Student student) {
        try {
            int result = studentDao.saveStudent(student);
            if (result == 1) {
                return new Response<>(200, "Successfully Inserted", null);
            } else {
                return new Response<>(400, "Already existed", null);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Response<Student> editStudent(Student student) {
        try {
            System.out.println(student + "Inside upda");
            int result = studentDao.updateStudent(student);
            if (result == 1) {
                return new Response<>(200, "Successfully Updated", null);
            } else {
                return new Response<>(400, "Not existed", null);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
