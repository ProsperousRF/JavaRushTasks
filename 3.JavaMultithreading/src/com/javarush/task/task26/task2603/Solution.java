package com.javarush.task.task26.task2603;

/*
Убежденному убеждать других не трудно
*/

import java.util.Comparator;

public class Solution {

  public static void main(String[] args) {}

  public static class CustomizedComparator<T> implements Comparator<T> {

    private final Comparator<T>[] comparators;

    public CustomizedComparator(Comparator<T>... compares) {
      this.comparators = compares;
    }

    @Override
    public int compare(T o1, T o2) {
      int res;
      for (Comparator<T> comparator : comparators) {
        res = comparator.compare(o1, o2);
        if (res != 0) return res;
      }
      return 0;
    }
  }
}
