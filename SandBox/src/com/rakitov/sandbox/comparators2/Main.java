package com.rakitov.sandbox.comparators2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Stanislav Rakitov
 */
public class Main {
  public static void main(String[] args) {
    List<Woman> women = new ArrayList<>();
    women.add(new Woman("Angie", 15, 175, 50, 0));
    women.add(new Woman("Kate", 34, 168, 67, 2));
    women.add(new Woman("Jackie", 44, 183, 57, 1));


    Comparator<Woman> compareByHeight = Comparator.comparingInt(Woman::getHeight);

    System.out.println("Before sort");
    women.forEach(System.out::println);
    System.out.println("\nAfter sort");
    women.sort(compareByHeight);
    women.forEach(System.out::println);

  }
}
