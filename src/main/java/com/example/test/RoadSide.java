package com.example.test;

public enum RoadSide {
  LEFT("왼쪽", "10M"), RIGHT("오른쪽", "20M");

  private String krName;
  private String width;

  private RoadSide() {

  }

  private RoadSide(String krName, String width) {
    this.krName = krName;
    this.width = width;
  }

  public String getKrName() {
    return krName;
  }

  public String getWidth() {
    return width;
  }
}
