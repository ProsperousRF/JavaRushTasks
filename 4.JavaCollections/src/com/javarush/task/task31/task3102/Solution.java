package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Находим все файлы
*/

public class Solution {
  public static List<String> getFileTree(String root) throws IOException {
    ArrayList<String> list;
    Path start = Paths.get(root);

    try (Stream<Path> stream = Files.walk(start, Integer.MAX_VALUE)) {
      list = (ArrayList<String>) stream
                  .map(String::valueOf)
                  .filter(pathName -> !Files.isDirectory(Paths.get(pathName)))
                  .sorted()
                  .collect(Collectors.toList());
    }

    return list;
  }

  public static void main(String[] args) throws IOException {
    List<String> list = getFileTree("/var/log");
    list.forEach(System.out::println);
  }
}
