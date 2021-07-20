package com.javarush.task.task22.task2202;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Stanislav Rakitov
 */
class Task2202Test {

  @Test
  @DisplayName("JavaRush - лучший сервис обучения Java.")
  public void firstSentence(){
    String testString = "JavaRush - лучший сервис обучения Java.";
    String resultString = "- лучший сервис обучения";
    assertEquals(resultString, Solution.getPartOfString(testString));
  }

  @Test
  @DisplayName("Амиго и Диего лучшие друзья!")
  public void secondSentence(){
    String testString = "Амиго и Диего лучшие друзья!";
    String resultString = "и Диего лучшие друзья!";
    assertEquals(resultString, Solution.getPartOfString(testString));
  }

  @Test
  @DisplayName("Null string")
  public void nullString() {
    assertThrows(Solution.TooShortStringException.class, () -> Solution.getPartOfString(
            null));
  }

  @Test
  @DisplayName("Empty string")
  public void emptyString() {
    assertThrows(Solution.TooShortStringException.class, () -> Solution.getPartOfString(
            ""));
  }

  @Test
  @DisplayName("String without spaces")
  public void noSpacesString() {
    assertThrows(Solution.TooShortStringException.class, () -> Solution.getPartOfString(
            "ThereAreNoSpaces"));
  }

  @Test
  @DisplayName("String with less than 4 spaces")
  public void notEnoughtSpacesString() {
    assertThrows(Solution.TooShortStringException.class, () -> Solution.getPartOfString(
            "Not Enough Spaces"));
  }


}