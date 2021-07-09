package com.javarush.task.task31.task3109;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/*
Читаем конфиги
*/

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    Properties properties =
        solution.getProperties(
            "4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
    properties.list(System.out);

    properties =
        solution.getProperties(
            "4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
    properties.list(System.out);

    properties =
        solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
    properties.list(System.out);
  }

  public Properties getProperties(String fileName) {
    Properties properties = new Properties();
    Paths.get(fileName);
    try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
      try {
        properties.loadFromXML(fileInputStream);
      } catch (InvalidPropertiesFormatException exception) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
          properties.load(reader);
        }
      }
    } catch (IOException e) {
      // Do nothing.
    }
    return properties;
  }
}
