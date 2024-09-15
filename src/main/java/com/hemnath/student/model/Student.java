package com.hemnath.student.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String cls;
    private String email;

    public Student(int id, String name, int age, String cls, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cls = cls;
        this.email = email;
    }

    public Student(String name, int age, String cls, String email) {
        this.name = name;
        this.age = age;
        this.cls = cls;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", claas='" + cls + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
