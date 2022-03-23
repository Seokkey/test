package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class TestApplication {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(TestApplication.class, args);
    // 변경


    System.out.println(LocalDateTime.of(LocalDate.now().minusDays(2), LocalTime.MIDNIGHT));

    // 날짜 테스트
    //      Calendar c = Calendar.getInstance();
    //      c.setTime(new Date());
    //      c.add(Calendar.DAY_OF_MONTH, 1);
    //      String date = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
    //
    //      System.out.println("endDate 시간 = [" + date + "]");
    // System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT));

    ;
    // log.info("LocalDateTime.from(LocalDate.now()) ::: {}", LocalDateTime.from(LocalDate.now()));

    // 정규식 테스트
    //      String str = "1";
    ////      Pattern pattern = Pattern.compile("^[0-9|-]+$");
    ////      Pattern pattern = Pattern.compile("^[0-9-]+$");
    //      Pattern pattern = Pattern.compile("^[0-9]+[0-9|-]?[0-9]?$");
    //      Matcher matcher = pattern.matcher(str);
    //
    //      if(matcher.find()) {
    //        System.out.println("정규식 통과 값"+str);
    //      } else {
    //        System.out.println("정규식 아닌 값 ");
    //      }

    // commit 1
    // commit 2
    // commit 3

    // enum 테스트
    //    System.out.println(RoadSide.RIGHT.getKrName() + RoadSide.RIGHT.getWidth());

    //    QueryParamBuilder queryParamBuilder = new QueryParamBuilder("PATH!강원도,DFT:*아침");
    //
    //    List<QueryParam> qr = queryParamBuilder.getParams();
    //
    //    qr.forEach(queryParam -> {
    //      System.out.println("getKey "+queryParam.getKey());
    //      System.out.println("getOperation "+queryParam.getOperation());
    //      System.out.println("getValue "+queryParam.getValue());
    //    });

    // for 테스트
    // LocalDateTime startDateTime = LocalDateTime.parse(
    //     "2021112513", DateTimeFormatter.ofPattern("yyyyMMddHH"));
    // List<LocalDateTime> localDateTimes = new ArrayList<>(); // 2021112513, 2021112514, 2021112515
    // for (int i = 0; i < 6 * 6; i++) { // 6 * 6 = 36
    //   System.out.println("i :: " + i);
    //   System.out.println("i / 6:: " + i/6);
    //   localDateTimes.add(startDateTime.plusHours(i / 6));
    // }
    //
    // System.out.println("localDateTimes :: " + localDateTimes);

    // flatMap 테스트
    // LocalDateTime preLdt = LocalDateTime.parse(
    //         "202108080136", DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
    //
    // System.out.println("LocalTime.MIN :::: "+LocalTime.MIN);
    // System.out.println("preLdt.with(LocalTime.MIN) :::: "+preLdt.with(LocalTime.MIN));
    // System.out.println("preLdt.with(LocalTime.MAX) :::: "+preLdt.with(LocalTime.MAX));
    // System.out.println("preLdt.with(LocalTime.NOON) :::: "+preLdt.with(LocalTime.NOON));
    // System.out.println("preLdt.with(LocalTime.MIDNIGHT) :::: "+preLdt.with(LocalTime.MIDNIGHT));
    //
    // LocalDateTime lastLdt = LocalDateTime.parse(
    //     "2021060801", DateTimeFormatter.ofPattern("yyyyMMddHH"));
    // Optional.of(preLdt)
    //     .map(
    //         maxDate -> {
    //           System.out.println("maxDate :: "+maxDate);
    //           System.out.println("lastLdt :: "+lastLdt);
    //           if (lastLdt.isAfter(maxDate) || lastLdt.isEqual(maxDate)) {
    //             System.out.println("날짜 같거나 이후 이후 임 null 리턴");
    //             return null;
    //           } else {
    //             return maxDate;
    //           }
    //         })
    //     .flatMap(
    //         predictionMaxDate -> {
    //           System.out.println("flatMap");
    //           System.out.println("날짜가 그 전임, 데이터 있음");
    //           System.out.println("predictionMaxDate ::: " + predictionMaxDate);
    //           return Optional.of("???");
    //         })
    //     .map(
    //         streamFileLast -> {
    //           System.out.println("map");
    //           System.out.println("streamFileLast ::: " + streamFileLast);
    //           return "???";
    //         })
    //     .orElseGet(
    //         () -> {
    //           System.out.println("orElseGet");
    //           return "??";
    //         });

    // List<Human> humans = null; // 널임 orElseThrow 탐
    // List<Human> humans = new ArrayList<>(); // 널 아님 orElseThrow 안탐
    //
    // // humans.add(new Human("", ""));
    //
    // // Optional.ofNullable(humans).ifPresentOrElse();
    // if (humans == null) System.out.println("널이네널");
    // if (ObjectUtils.isEmpty(humans)) System.out.println("엠티네 엠티");
    // Optional.ofNullable(humans).orElseThrow(() -> new Exception("널이다"));

    //   List<String> adf = new ArrayList<>();
    //
    //   adf.add("a");
    //   adf.add("b");
    //   adf.add("c");
    //
    //   Optional.ofNullable(adf)
    //       .map(
    //           strings -> {
    //             System.out.println("map" + strings);
    //             return "";
    //           });
    //
    //   Optional.ofNullable(adf)
    //       .flatMap(
    //           strings -> {
    //             System.out.println("flatmap" + strings);
    //             return Optional.of(strings);
    //           });
    // }
    //
    // public static class Human {
    //   private String age;
    //   private String name;
    //
    //   public Human(String age, String name) {
    //     this.age = age;
    //     this.name = name;
    //   }

    // CompletableFuture 테스트

    /**
     * newCachedThreadPool()으로 직접 쓰레드를 만들었고, 그 쓰레드의 작업이 완료되면 complete("Finished")으로 결과를 Future에
     * 저장하였습니다. 결과가 저장되면 get()은 값을 리턴하며 block된 상태에서 빠져나옵니다.
     */
    // CompletableFuture<String> future
    //     = new CompletableFuture<>();
    // Executors.newCachedThreadPool().submit(() -> {
    //   Thread.sleep(2000);
    //   future.complete("Finished");
    //   return null;
    // });
    // log(future.get());

    /** 이미 값을 알고 있다면 쓰레드를 만들지 않고 completedFuture()으로 값을 할당할 수 있습니다. */
    // Future<String> completableFuture =
    //     CompletableFuture.completedFuture("Skip!");
    //
    // String result = completableFuture.get();
    // log(result);

    /**
     * 쓰레드에서 cancle()이 호출될 수 있습니다. 이 때, get()에서 CancellationException이 발생하기 때문에 아래와 같이 예외처리를 해야 합니다.
     */
    // CompletableFuture<String> future
    //     = new CompletableFuture<>();
    // Executors.newCachedThreadPool().submit(() -> {
    //   Thread.sleep(2000);
    //   future.cancel(false);
    //   return null;
    // });
    // String result = null;
    // try {
    //   result = future.get();
    // } catch (CancellationException e) {
    //   e.printStackTrace();
    //   result = "Canceled!";
    // }
    // log(result);

    /**
     * CompletableFuture는 supplyAsync()와 runAsync()를 제공하여 직접 쓰레드를 생성하지 않고 작업을 async로 처리하도록 할 수 있습니다.
     * 이런식으로 supplyAsync()에 Lambda로 인자를 전달할 수 있습니다. 인자로 전달된 Lambda는 다른 쓰레드에서 처리가 됩니다.
     */
    // CompletableFuture<String> future
    //     = CompletableFuture.supplyAsync(() -> "future example");
    // // 결과를 보면 main이 아닌 다른 쓰레드에서 처리되는 것을 알 수 있습니다. ???
    // log("get(): " + future.get());

    /** Lambda에 2초간 sleep하도록 하였습니다. main에서 호출되는 future.get()은 2초간 blocking되고 완료되면 리턴값을 받습니다. */
    // CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    //   log("Starting....");
    //   try {
    //     Thread.sleep(2000);
    //   } catch (InterruptedException e) {
    //     e.printStackTrace();
    //   }
    //   return "Finished works";
    // });
    // log("get(): " + future.get());

    /** runAsync()도 사용방법은 동일합니다. supplyAsync()는 리턴 값이 있는 반면에 runAsync()는 리턴값이 없습니다 */
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> log("future example"));
    log("get(): " + future.get());

    /**
     * 처리가 완료될 때까지 기다리지 않아도 된다면 다음과 같이 짧게 구현할 수도 있습니다.
     * */
    CompletableFuture.runAsync(() -> log("future example"));
  }

  public static void log(String msg) {
    System.out.println(LocalTime.now() + " (" + Thread.currentThread().getName() + ") " + msg);
  }
}
