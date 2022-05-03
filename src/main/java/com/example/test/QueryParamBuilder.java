package com.example.test;

import org.springframework.util.ObjectUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryParamBuilder {
  private final List<QueryParam> params = new LinkedList();

  public QueryParamBuilder(String query) {
    this.build(query);
    System.out.println("조회조건 객체 생성");
  }

  private void build(String search) {
    if (!ObjectUtils.isEmpty(search)) {
      String operationSetExper = String.join("|", QueryOperation.SIMPLE_OPERATION_SET);
      System.out.println("operationSetExper"+operationSetExper);
      Pattern pattern = Pattern.compile("([ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|'-|\\*]+?)(" + operationSetExper + ")([\\p{Punct}&&[^()]]?)([ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|'-|\\*\\s)]+?)([\\p{Punct}&&[^()]]?),");
      Matcher matcher = pattern.matcher(search + ",");

      while(matcher.find()) {
        this.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
      }
    }

  }

  private void with(String key, String operation, String value, String prefix, String suffix) {
    System.out.println("조회조건 반환 key " + key);
    System.out.println("조회조건 반환 operation " + operation);
    System.out.println("조회조건 반환 value " + value);
    System.out.println("조회조건 반환 prefix " + prefix);
    System.out.println("조회조건 반환 suffix " + suffix);
    QueryOperation qo = QueryOperation.getSimpleOperation(operation);
    System.out.println("오퍼레이션 qo "+qo);
    if (qo != null) {
      if (qo == QueryOperation.EQUALITY) {
        boolean startWithAsterisk = prefix.contains("*");
        boolean endWithAsterisk = suffix.contains("*");
        boolean startWithNot = suffix.contains("^");
        boolean endWithNot = prefix.contains("^");
        if (startWithAsterisk && endWithAsterisk) {
          qo = QueryOperation.CONTAINS;
        } else if (startWithAsterisk) {
          qo = QueryOperation.STARTS_WITH;
        } else if (endWithAsterisk) {
          qo = QueryOperation.ENDS_WITH;
        } else if (startWithNot) {
          qo = QueryOperation.NOT_NULL;
        } else if (endWithNot) {
          qo = QueryOperation.NULL;
        }
      }

      this.params.add(new QueryParam(CamelCaseUtils.toSnakeCase(key), qo, value));
    }

  }

  public List<QueryParam> getParams() {
    return this.params;
  }
}
