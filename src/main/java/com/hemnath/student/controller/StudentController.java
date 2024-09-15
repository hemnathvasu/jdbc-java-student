package com.hemnath.student.controller;

import com.hemnath.student.dao.StudentDao;
import com.hemnath.student.model.Response;
import com.hemnath.student.model.Student;
import com.hemnath.student.service.StudentService;
import com.google.gson.*;

import java.util.List;

public class StudentController {
    public static void main(String[] args) {

        StudentDao repository = new StudentDao();
        StudentService service = new StudentService(repository);
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Get by Id
//        Response<Student> response = service.getStudent(1);
//        String jsonResponse = gson.toJson(response);
//        System.out.println(jsonResponse);

        //Get all student records;
//        Response<List<Student>> response = service.getAllStudent();
//        String jsonResponse = gson.toJson(response);
//        System.out.println(jsonResponse);

        //Delete student
//        Response<Student> response = service.removeStudent(2);
//        String jsonResponse = gson.toJson(response);
//        System.out.println(jsonResponse);
    }
}
