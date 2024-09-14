package com.hemnath.student.controller;

import com.hemnath.student.dao.StudentDao;
import com.hemnath.student.model.Student;
import com.hemnath.student.service.StudentService;

public class StudentController {
    public static void main(String[] args) {
        StudentDao repository = new StudentDao();
        StudentService service = new StudentService(repository);

        Student student = service.getStudentById(1);
        System.out.println(student);
    }
}
