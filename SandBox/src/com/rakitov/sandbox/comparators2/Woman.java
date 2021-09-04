package com.rakitov.sandbox.comparators2;

/**
 * @author Stanislav Rakitov
 */
public class Woman {
  private String name;
  private int age;
  private int height;
  private int weight;
  private int children;

  /**
   * Some abstract woman class
   *
   * @param name Woman's name
   * @param age Her age
   * @param height Height in cm
   * @param weight Weight in kg
   * @param children Number of children
   */
  public Woman(String name, int age, int height, int weight, int children) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.children = children;
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

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getChildren() {
    return children;
  }

  public void setChildren(int children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return String.format("%s is %d years old. Height: %d kg. Weight: %d cm. Number of " +
                                    "children: %d",
                         name, age, height, weight, children);
  }
}
