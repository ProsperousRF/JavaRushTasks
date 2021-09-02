package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected int[] size;

    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private int bloodGroup;
    private List<Human> children = new ArrayList<>();

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

//    public Human(boolean isSoldier) {
//        this.isSoldier = isSoldier;
//        this.id = nextId;
//        nextId++;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
//        return children;
    }


//    public void setChildren(List<Human> children) {
//        this.children = children;
//    }

    public void addChild(Human child){
        children.add(child);
    }

    public void removeChild(Human child){
        children.remove(child);
    }

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }

    @Override
    public void live() {

    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public String getPosition(){
        return "Человек";
    }
}