package com.example.test;

public class CamelCaseUtils {
  public static String toCamelCase(String underScore) {
    if (underScore.indexOf(95) < 0 && Character.isLowerCase(underScore.charAt(0))) {
      return underScore;
    } else {
      StringBuilder result = new StringBuilder();
      boolean nextUpper = false;
      int len = underScore.length();

      for(int i = 0; i < len; ++i) {
        char currentChar = underScore.charAt(i);
        if (currentChar == '_') {
          nextUpper = true;
        } else if (nextUpper) {
          result.append(Character.toUpperCase(currentChar));
          nextUpper = false;
        } else {
          result.append(Character.toLowerCase(currentChar));
        }
      }

      return result.toString();
    }
  }

  public static String toSnakeCase(String underScore) {
    StringBuilder result = new StringBuilder();
    int len = underScore.length();

    for(int i = 0; i < len; ++i) {
      char currentChar = underScore.charAt(i);
      if (Character.isUpperCase(currentChar)) {
        result.append("_").append(Character.toUpperCase(currentChar));
      } else {
        result.append(Character.toUpperCase(currentChar));
      }
    }

    return result.toString();
  }

  private CamelCaseUtils() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
}
