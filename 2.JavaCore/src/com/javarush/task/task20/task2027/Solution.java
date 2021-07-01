package com.javarush.task.task20.task2027;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
  public static void main(String[] args) {
    int[][] crossword =
        new int[][] {
          {' ', 'd', 'l', 'r', 'o', 'w'},
          {' ', 'r', ' ', ' ', 'r', ' '},
          {' ', 'o', 'd', ' ', 'd', 'd'},
          {'d', 'w', 'o', 'r', 'd', 'r'},
          {'r', 'o', ' ', ' ', 'o', 'o'},
          {'o', 'r', ' ', ' ', ' ', 'w'},
          {'w', 'd', 'r', 'o', 'o', 'w'}
        };
    detectAllWords(crossword, "word");
    /*
      a - (0, 0) - (0, 0)
      a - (1, 0) - (1, 0)
      a - (0, 1) - (0, 1)
      a - (1, 1) - (1, 1)
    */
  }

  public static List<Word> detectAllWords(int[][] crossword, String... words) {
    List<Word> list = new ArrayList<>();

    for (String word : words) {
      if (!word.isEmpty()) {
        byte[] byteWord = word.toLowerCase().getBytes(StandardCharsets.UTF_8);
        int[] intWord = new int[byteWord.length];
        for (int i = 0; i < byteWord.length; i++) {
          intWord[i] = byteWord[i];
        }
        for (int y = 0; y < crossword.length; y++) {
          for (int x = 0; x < crossword[y].length; x++) {
            if (crossword[y][x] == intWord[0]) {
              // One letter word check
              if (intWord.length == 1) {
                addWordToList(list, word, x, y, x, y);
              } else {
                getEndPointsArray(list, word, crossword, intWord, x, y);
              }
            }
          }
        }
      }
    }
    return list;
  }

  private static void getEndPointsArray(
      List<Word> list,
      String word,
      int[][] crossword,
      int[] intWord,
      int startPointX,
      int startPointY) {

    int[] horizontalLine = crossword[startPointY];
    int[] verticalLine = makeVerticalLine(crossword, startPointX);

    Integer[] integerWord = Arrays.stream(intWord).boxed().toArray(Integer[]::new);
    int secondByte = intWord[1];

    // Try horizontal line right
    if ((intWord.length <= (horizontalLine.length - startPointX))
        && ((horizontalLine.length - intWord.length) >= startPointX)
        && (secondByte == crossword[startPointY][startPointX + 1])) {
      int endPointTemp = startPointX + intWord.length;
      int[] rightArray = Arrays.copyOfRange(horizontalLine, startPointX, endPointTemp);
      if (Arrays.equals(rightArray, intWord)) {
        int endPointX = endPointTemp - 1;
        addWordToList(list, word, startPointX, startPointY, endPointX, startPointY);
        //        return new int[] {endPointTemp - 1, startPointY};
      }
    }

    // Try horizontal line left
    if ((intWord.length <= horizontalLine.length)
        && ((1 + startPointX - intWord.length) >= 0)
        && (startPointX - 1 >= 0)
        && (secondByte == horizontalLine[startPointX - 1])) {
      int startPointTemp = startPointX - intWord.length + 1;
      int endPointTemp = startPointX + 1;
      int[] leftIntArray = Arrays.copyOfRange(horizontalLine, startPointTemp, endPointTemp);
      Integer[] leftArray = Arrays.stream(leftIntArray).boxed().toArray(Integer[]::new);
      Collections.reverse(Arrays.asList(leftArray));
      if (Arrays.equals(leftArray, integerWord)) {
        addWordToList(list, word, startPointX, startPointY, startPointTemp, startPointY);
      }
    }

    // Try vertical line down
    if ((intWord.length <= verticalLine.length)
        && ((verticalLine.length - startPointY) >= intWord.length)
        && (secondByte == verticalLine[startPointY + 1])) {
      int endPointTemp = startPointY + intWord.length;
      int[] rightDownArray = Arrays.copyOfRange(verticalLine, startPointY, endPointTemp);
      if (Arrays.equals(rightDownArray, intWord)) {
        addWordToList(list, word, startPointX, startPointY, startPointX, endPointTemp - 1);
      }
    }

    // Try vertical line up
    if ((intWord.length <= verticalLine.length)
        && (startPointY >= intWord.length -1)
        && (secondByte == verticalLine[startPointY - 1])
        ) {
      int startPointTemp = startPointY - intWord.length + 1;
      int endPointTemp = startPointY + 1;
      int[] verticalLeftIntArray = Arrays.copyOfRange(verticalLine, startPointTemp, endPointTemp);
      Integer[] verticalLeftArray =
          Arrays.stream(verticalLeftIntArray).boxed().toArray(Integer[]::new);
      Collections.reverse(Arrays.asList(verticalLeftArray));
      if (Arrays.equals(verticalLeftArray, integerWord)) {
        addWordToList(list, word, startPointX, startPointY, startPointX, startPointTemp);
      }
    }



    // Try Down-Right diagonal
    if ((startPointX + 1 < crossword[startPointY].length && startPointY + 1 < crossword.length)
        && secondByte == crossword[startPointY + 1][startPointX + 1]) {
      Integer[] diagonal = new Integer[integerWord.length];
      for (int i = 0; i < integerWord.length; i++) {
        try {
          diagonal[i] = crossword[startPointY + i][startPointX + i];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException exception) {
          break;
        }
      }
      if (Arrays.equals(diagonal, integerWord)) {
        addWordToList(list, word, startPointX, startPointY, startPointX + integerWord.length - 1, startPointY + integerWord.length - 1);
      }
    }

    // Try Down-Left diagonal
    if ((startPointX - 1 >= 0 && startPointY + 1 < crossword.length)
        && secondByte == crossword[startPointY + 1][startPointX - 1]) {
      Integer[] diagonal = new Integer[integerWord.length];
      for (int i = 0; i < integerWord.length; i++) {
        try {
          diagonal[i] = crossword[startPointY + i][startPointX - i];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException exception) {
          break;
        }
      }
      if (Arrays.equals(diagonal, integerWord)) {
        addWordToList(list, word, startPointX, startPointY, startPointX - intWord.length + 1, startPointY + integerWord.length - 1);
      }
    }

    // Try Up-Right
    if ((startPointX + 1 < crossword[startPointY].length && startPointY - 1 >= 0)
        && secondByte == crossword[startPointY - 1][startPointX + 1]) {
      Integer[] diagonal = new Integer[integerWord.length];
      for (int i = 0; i < integerWord.length; i++) {
        try {
          diagonal[i] = crossword[startPointY - i][startPointX + i];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException exception) {
          break;
        }
      }
      if (Arrays.equals(diagonal, integerWord)) {
        addWordToList(list, word, startPointX, startPointY, startPointX + intWord.length - 1, startPointY - integerWord.length + 1);
      }
    }

    // Try Up-Left
    if ((startPointY - 1 >= 0 && startPointX - 1 >= 0)
        && secondByte == crossword[startPointY - 1][startPointX - 1]) {
      Integer[] diagonal = new Integer[integerWord.length];
      for (int i = 0; i < integerWord.length; i++) {
        try {
          diagonal[i] = crossword[startPointY - i][startPointX - i];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException exception) {
          break;
        }
      }
      if (Arrays.equals(diagonal, integerWord)) {
        addWordToList(list, word, startPointX, startPointY, startPointX - intWord.length + 1, startPointY - integerWord.length + 1);
      }
    }
  }

  private static void addWordToList(
      List<Word> list,
      String word,
      int startPointX,
      int startPointY,
      int endPointX,
      int endPointY) {
    Word temp = new Word(word);
    temp.setStartPoint(startPointX, startPointY);
    temp.setEndPoint(endPointX, endPointY);
    System.out.println(temp);
    list.add(temp);
  }

  private static int[] makeVerticalLine(int[][] crossword, int startPointX) {
    int[] intArr = new int[crossword.length];
    for (int y = 0; y < crossword.length; y++) {
      intArr[y] = crossword[y][startPointX];
    }
    return intArr;
  }

  public static class Word {
    private String text;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Word(String text) {
      this.text = text;
    }

    public void setStartPoint(int x, int y) {
      startX = x;
      startY = y;
    }

    public void setEndPoint(int x, int y) {
      endX = x;
      endY = y;
    }

    @Override
    public String toString() {
      return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
    }
  }
}
