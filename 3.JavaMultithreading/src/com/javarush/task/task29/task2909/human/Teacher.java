package com.javarush.task.task29.task2909.human;

public class Teacher extends UniversityPerson {
    protected boolean isSoldier;
    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
//        this.name = name;
//        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public void fight() {
    }

    @Override
    public String getPosition() {
        return "Преподаватель";
    }
}