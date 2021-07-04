package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Проход по дереву файлов
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    Path wayToPath = Paths.get(args[0]);
    File resultFileAbsolutePath = new File(String.valueOf(Paths.get(args[1])));

    File destinationFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

    FileUtils.renameFile(resultFileAbsolutePath, destinationFile);

    List<File> resultFiles =
        Files.walk(Paths.get(args[0]))
            .filter(Files::isRegularFile)
            .map(Path::toFile)
            .filter(file -> file.length() <= 50)
            .sorted(Comparator.comparing(File::getName))
            .collect(Collectors.toList());

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
      for (File file : resultFiles) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
          String line;
          while ((line = reader.readLine()) != null) {
            writer.write(line);
          }
          writer.newLine();
        }
      }
    }
  }
}
