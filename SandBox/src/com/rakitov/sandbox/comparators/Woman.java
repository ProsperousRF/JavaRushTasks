package com.rakitov.sandbox.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Stanislav Rakitov
 */
public class Woman implements Comparable<Woman>{
  private final int age;

  public Woman(int age) {
    this.age = age;
  }

  @Override
  public int compareTo(Woman woman) {
    return this.age - woman.age;
  }

  public static void main(String[] args) {
    List<Woman> women = new ArrayList<>();
    women.add(new Woman(57));
    women.add(new Woman(27));
    women.add(new Woman(17));
    women.add(new Woman(43));

    System.out.println("Before sort");
    women.forEach(System.out::println);
    System.out.println("\nAfter sort");
    Collections.sort(women);
    women.forEach(System.out::println);

  }

  @Override
  public String toString() {
    return "Woman age of " + age;
  }
}


