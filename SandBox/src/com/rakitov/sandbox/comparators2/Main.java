package com.rakitov.sandbox.comparators2;

import java.util.ArrayList;
import java.util.Collections;
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

    // Anonymous new Comparator<Woman>() can be replaced with lambda
    Comparator<Woman> compareByName = new Comparator<Woman>() {
      @Override
      public int compare(Woman w1, Woman w2) {
        return w1.getName().compareTo(w2.getName());
      }
    };
    // Like this, but it Can be replaced with 'Comparator.comparing'
    Comparator<Woman> compareByNameLambda = (w1, w2) -> w1.getName().compareTo(w2.getName());
    // Can be replaced with 'Comparator.comparing'
    Comparator<Woman> compareByNameComparator = Comparator.comparing(Woman::getName);


    // Lambda can be replaced with method reference
    Comparator<Woman> compareByHeight = Comparator.comparingInt(woman -> woman.getHeight());

    System.out.println("Before sort");
    women.forEach(System.out::println);
    System.out.println("\nAfter sort height");

    // Collections.sort could be replaced with List.sort
    Collections.sort(women, compareByHeight);
    women.forEach(System.out::println);
    System.out.println("\nAfter sort weight");
    // Can sort like this too.
    // and another way to make a comparator
    women.sort(Comparator.comparingInt(Woman::getWeight));
    women.forEach(System.out::println);

    System.out.println("\nAfter name sort");
    women.sort(compareByName);
    women.forEach(System.out::println);

  }
}
