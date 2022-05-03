package com.example.test;

import java.beans.ConstructorProperties;

public class QueryParam {
  private static final long serialVersionUID = -953905334454392659L;
  private final String key;
  private final QueryOperation operation;
  private final Object value;

  @ConstructorProperties({"key", "operation", "value"})
  public QueryParam(String key, QueryOperation operation, Object value) {
    this.key = key;
    this.operation = operation;
    this.value = value;
  }

  public String getKey() {
    return this.key;
  }

  public QueryOperation getOperation() {
    return this.operation;
  }

  public Object getValue() {
    return this.value;
  }
}
