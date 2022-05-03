package com.example.test;

public enum QueryOperation {
  EQUALITY,
  NEGATION,
  GREATER_THAN,
  LESS_THAN,
  LIKE,
  STARTS_WITH,
  ENDS_WITH,
  CONTAINS,
  NULL,
  NOT_NULL;

  protected static final String[] SIMPLE_OPERATION_SET =
      new String[] {":", "!", ">", "<", "%", "&gt;", "&lt;"};

  private QueryOperation() {}

  public static QueryOperation getSimpleOperation(String input) {
    byte var2 = -1;
    switch (input.hashCode()) {
      case 33:
        if (input.equals("!")) {
          var2 = 1;
        }
        break;
      case 37:
        if (input.equals("%")) {
          var2 = 6;
        }
        break;
      case 58:
        if (input.equals(":")) {
          var2 = 0;
        }
        break;
      case 60:
        if (input.equals("<")) {
          var2 = 4;
        }
        break;
      case 62:
        if (input.equals(">")) {
          var2 = 2;
        }
        break;
      case 1234696:
        if (input.equals("&gt;")) {
          var2 = 3;
        }
        break;
      case 1239501:
        if (input.equals("&lt;")) {
          var2 = 5;
        }
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + input.hashCode());
    }

    switch (var2) {
      case 0:
        return EQUALITY;
      case 1:
        return NEGATION;
      case 2:
      case 3:
        return LESS_THAN;
      case 4:
      case 5:
        return GREATER_THAN;
      case 6:
        return LIKE;
      default:
        return null;
    }
  }
}
