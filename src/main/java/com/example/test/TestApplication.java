package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ObjectUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class TestApplication {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(TestApplication.class, args);
    // rebase test1
    // rebase test2
    // rebase test3
    // rebase test complete
    // 로그인 기능 추가1
    // 로그아웃 기능 추가

    /** 파일 확장자 */
    try (Stream<Path> stream = Files.walk(Paths.get("/Users/ust21/koos/kiost/ctd"))) {
      stream.filter(path -> {
            if (!Files.isDirectory(path)
                && !path.toFile().isHidden()) {
              return fileMapper
                  .select(
                      mtrSn,
                      getMtrPrdtDt(mtrSn, path.toString()),
                      path.getFileName().toString())
                  .map(
                      file -> {
                        String checksum = FileUtils.checksum(path);
                        return !file.getFileChecksum().equals(checksum);
                      })
                  .orElse(true);
            } else {
              return false;
            }
          })
          .forEach(
          path -> {
            String a =
                path.getFileName()
                    .toString()
                    .substring(path.getFileName().toString().lastIndexOf('.') + 1);
            System.out.println(a);
          });
    }

    /** 배열 역정렬 */
    // String[] colorArray = {
    //   "#006FFF", "#0080FF", "#008FFF", "#009EFF", "#009EFF", "#00AFFF", "#00BEFF", "#00CFFF",
    // };
    // System.out.println(colorArray.length);
    // double a = 0;
    // List<String> listItem = Arrays.asList(colorArray);
    // // 역정렬
    // Collections.reverse(listItem);
    // String[] reversed = listItem.toArray(colorArray);
    // System.out.println("리버스 후 배열: " + Arrays.toString(reversed));
    // for (int i = 0; i < reversed.length; i++) {
    //   a = a + 1.5625;
    //   String c = "<ogc:Literal>" + reversed[i] + "</ogc:Literal>";
    //   String v = "<ogc:Literal>" + a + "</ogc:Literal>";
    //   // String c = "<ColorMapEntry color=\"" + reversed[i] + "\" quantity=\""+a+"\"
    //   // label=\"values\" />";
    //
    //   // System.out.println(i + "번째");
    //   // System.out.println(a);
    //   System.out.println(c);
    //   System.out.println(v);
    // }

    /** 인피니티 여부 확인 */
    // Double infinite = 10d / 0; // true
    // Double infinite = 10d / 3; // false
    // System.out.println("인피니티?? " + infinite + Double.isInfinite(infinite));

    /** String format 02d 테스트 */
    // String v = "1";
    // String v = "41";
    // String format02d = String.format("N%02d", Integer.parseInt(v));
    //
    // System.out.println("format02d => " + format02d);
    // System.out.println("sumFloat => " + sumFloat);

    /** 부동소수점 연산 */
    // double value1 = 12.23;
    // double value2 = 34.45;
    // double sumDouble = value1 + value2;
    //
    // float value3 = 12.23f;
    // float value4 = 34.45f;
    // float sumFloat = value3 + value4;
    //
    // // 46.68 ???
    // System.out.println("sumDouble => " + sumDouble);
    // System.out.println("sumFloat => " + sumFloat);

    /** 시간 단위 까지만 비교 */
    // System.out.println(LocalDateTime.parse(
    //     "2022041415", DateTimeFormatter.ofPattern("yyyyMMddHH")).isEqual(LocalDateTime.of(2022,
    // 4, 14, 15, 6).truncatedTo(ChronoUnit.HOURS)));

    /** 일 단위 까지만 비교 */
    // System.out.println(LocalDateTime.parse(
    //     "2022041415",
    // DateTimeFormatter.ofPattern("yyyyMMddHH")).truncatedTo(ChronoUnit.DAYS).isEqual(LocalDateTime.of(2022,
    // 4, 14, 15, 6).truncatedTo(ChronoUnit.DAYS)));
    //
    // System.out.println(LocalDateTime.of(2022,
    //     4, 14, 15, 6).truncatedTo(ChronoUnit.DAYS));

    /** 중복 제거 테스트 */
    // List<FileDto.Req> fileReqList = new ArrayList<>();
    // FileDto.Req reqBuilder1 =
    //     FileDto.Req.builder()
    //         .mtrSn(17) // pk
    //         .mtrPrdtDt(
    //             LocalDateTime.parse(
    //                 "2019_10_03_2100", DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmm"))) // pk
    //         .fileNm("파일1") // pk
    //         .mtrTyCd("STREM")
    //         .mtrSttCd("READY")
    //         .filePth("경로")
    //         .fileExsn("확장자")
    //         .fileChecksum("1234")
    //         .build();
    //
    // FileDto.Req reqBuilder2 =
    //     FileDto.Req.builder()
    //         .mtrSn(17) // pk
    //         .mtrPrdtDt(
    //             LocalDateTime.parse(
    //                 "2019_10_03_2100", DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmm"))) // pk
    //         .fileNm("TOTL_JEJU_2019_10_03_2100.tuv") // pk
    //         .fileNm("파일1") // pk
    //         .mtrTyCd("STREM")
    //         .mtrSttCd("READY")
    //         .filePth("경로")
    //         .fileExsn("확장자")
    //         .fileChecksum("4567")
    //         .build();
    //
    // FileDto.Req reqBuilder3 =
    //     FileDto.Req.builder()
    //         .mtrSn(17) // pk
    //         .mtrPrdtDt(
    //             LocalDateTime.parse(
    //                 "2019_10_03_2100", DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmm"))) // pk
    //         .fileNm("파일2") // pk
    //         .mtrTyCd("STREM")
    //         .mtrSttCd("READY")
    //         .filePth("경로")
    //         .fileExsn("확장자")
    //         .fileChecksum("1234")
    //         .build();
    //
    //
    // FileDto.Req reqBuilder4 =
    //     FileDto.Req.builder()
    //         .mtrSn(17) // pk
    //         .mtrPrdtDt(
    //             LocalDateTime.parse(
    //                 "2019_10_03_2100", DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmm"))) // pk
    //         .fileNm("파일2") // pk
    //         .mtrTyCd("STREM")
    //         .mtrSttCd("READY")
    //         .filePth("경로")
    //         .fileExsn("확장자")
    //         .fileChecksum("1234")
    //         .build();
    //
    // FileDto.Req reqBuilder5 =
    //     FileDto.Req.builder()
    //         .mtrSn(17) // pk
    //         .mtrPrdtDt(
    //             LocalDateTime.parse(
    //                 "2019_10_03_2100", DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmm"))) // pk
    //         .fileNm("파일2") // pk
    //         .mtrTyCd("STREM")
    //         .mtrSttCd("READY")
    //         .filePth("경로")
    //         .fileExsn("확장자")
    //         .fileChecksum("1234")
    //         .build();
    //
    // FileDto.Req reqBuilder6 =
    //     FileDto.Req.builder()
    //         .mtrSn(17) // pk
    //         .mtrPrdtDt(
    //             LocalDateTime.parse(
    //                 "2019_10_03_2100", DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmm"))) // pk
    //         .fileNm("파일2") // pk
    //         .mtrTyCd("STREM")
    //         .mtrSttCd("READY")
    //         .filePth("경로")
    //         .fileExsn("확장자")
    //         .fileChecksum("1234")
    //         .build();
    //
    // fileReqList.add(reqBuilder1);
    // fileReqList.add(reqBuilder2);
    // fileReqList.add(reqBuilder3);
    // fileReqList.add(reqBuilder4);
    // fileReqList.add(reqBuilder5);
    // fileReqList.add(reqBuilder6);
    //
    // fileReqList.stream()
    //     .filter(distinctByKeys(FileDto.Req::getMtrSn, FileDto.Req::getMtrPrdtDt,
    // FileDto.Req::getFileNm))
    //     .distinct()
    //     .forEach(req -> System.out.println(req));

    /** 날짜 테스트 */
    //      Calendar c = Calendar.getInstance();
    //      c.setTime(new Date());
    //      c.add(Calendar.DAY_OF_MONTH, 1);
    //      String date = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
    //
    //      System.out.println("endDate 시간 = [" + date + "]");
    // System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT));

    ;
    // log.info("LocalDateTime.from(LocalDate.now()) ::: {}", LocalDateTime.from(LocalDate.now()));

    // System.out.println(LocalDateTime.of(LocalDate.now().minusDays(2), LocalTime.MIDNIGHT));
    // double direction =  getCurrentDirect(7.330, -73.493);
    // double speed =getCurrentSpeed(7.330, -73.493);
    // System.out.println("direction:: "+direction);
    // System.out.println("speed:: "+speed);

    /** 정규식 테스트 */
    // String str = "1";
    ////      Pattern pattern = Pattern.compile("^[0-9|-]+$");
    ////      Pattern pattern = Pattern.compile("^[0-9-]+$");
    // Pattern pattern = Pattern.compile("^[0-9]+[0-9|-]?[0-9]?$");
    // Matcher matcher = pattern.matcher(str);
    //
    // if (matcher.find()) {
    //   System.out.println("정규식 통과 값" + str);
    // } else {
    //   System.out.println("정규식 아닌 값 ");
    // }

    /** enum 테스트 */
    // System.out.println(RoadSide.RIGHT.getKrName() + ", " + RoadSide.RIGHT.getWidth());

    /** 쿼리 파람 테스트1 */
    // QueryParamBuilder queryParamBuilder = new QueryParamBuilder("PATH!강원도,DFT:*아침");
    // List<QueryParam> qr = queryParamBuilder.getParams();
    // qr.forEach(
    //     queryParam -> {
    //       System.out.println("getKey " + queryParam.getKey());
    //       System.out.println("getOperation " + queryParam.getOperation());
    //       System.out.println("getValue " + queryParam.getValue());
    //     });

    /** for 테스트 */
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

    /** flatMap 테스트 */
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

    /** Stream Foreach, map null 인 경우 확인 */
    //   List<String> foreachTestList = new ArrayList<>();
    //   //
    // foreachTestList.add("a");
    // foreachTestList.add("b");
    // foreachTestList.add("c");
    //
    // foreachTestList.stream()
    //     .forEach(
    //         s -> {
    //           // Stream forEach 는 리스트가 null인 경우 그냥 안탐 에러 없음
    //           System.out.println("s");
    //         });
    //
    // foreachTestList.forEach(
    //     s -> {
    //       // List.forEach 도 리스트가 null인 경우 그냥 안탐 에러 없음
    //       System.out.println("걍 포이치"+ s);
    //     });
    // System.out.println("foreachTestList" + foreachTestList);
    //
    // List<String> mapTestList = foreachTestList.stream()
    //     .map(
    //         s -> {
    //           // Stream map도 리스트가 null인 경우 그냥 안탐 에러 없음
    //           System.out.println("s");
    //           return  s;
    //         }).collect(Collectors.toList());
    //
    // System.out.println("mapTestList" + mapTestList);

    /** Optional ofNullable 널 체크 확인 */
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

    /** CompletableFuture 테스트 */
    /**
     * newCachedThreadPool()으로 직접 쓰레드풀을 만들었고, 그 쓰레드의 작업이 완료되면 complete("Finished")으로 결과를 Future에
     * 저장하였습니다. 결과가 저장되면 get()은 값을 리턴하며 block된 상태에서 빠져나옵니다.
     */
    // CompletableFuture<String> future
    //     = new CompletableFuture<>();
    // Executors.newCachedThreadPool().submit(() -> {
    //   Thread.sleep(5000);
    //   future.complete("Finished");
    //   return null;
    // });
    // log("여기 호출");
    // log(future.get());
    // log("여기 호출2");
    /** 이미 값을 알고 있다면 쓰레드를 만들지 않고 completedFuture()으로 값을 할당할 수 있습니다. */
    // Future<String> completableFuture =
    //     CompletableFuture.completedFuture("Skip!");
    // String result = completableFuture.get();
    // log(result);

    /**
     * 쓰레드에서 cancle()이 호출될 수 있습니다. 이 때, get()에서 CancellationException이 발생하기 때문에 아래와 같이 예외처리를 해야 합니다.
     */
    // CompletableFuture<String> future
    //     = new CompletableFuture<>();
    // Executors.newCachedThreadPool().submit(() -> {
    // // Executors.newFixedThreadPool(1).submit(() -> {
    //   Thread.sleep(5000);
    //   // future.cancel(false);
    //   // return null;
    //   return "쓰레스 작업통과";
    // });
    // String result = null;
    // try {
    //   result = future.get();
    // } catch (CancellationException e) {
    //   System.out.println("예외처리");
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
    // CompletableFuture<Void> future = CompletableFuture.runAsync(() -> log("future example"));
    // log("get(): " + future.get());

    /** 처리가 완료될 때까지 기다리지 않아도 된다면 다음과 같이 짧게 구현할 수도 있습니다. */
    // CompletableFuture.runAsync(() -> log("future example"));

    // CompletableFuture.join() 메소드는 get 메소드와 비슷한데, join 메소드는 Future 가 일반적으로 complete 되지 않으면
    // unchecked exception 을 발생시킨다.
    // allOf()의 메소드 시그니처를 보면 아시겠지만, 해당 메소드는 모든 CompletableFuture에 Blocking만 걸 뿐, 결과를 직접 반환하지는
    // 않습니다.따라서 모든 작업이 완료되었음을 allOf()를 통해 보장받고 나면, thenApply()를 통해 직접 given절의 CompletableFuture
    // 리스트에서 join()으로 값을 꺼내주는 작업을 거쳐야 합니다.

    /** --메인 종료 */
  }

  public static void log(String msg) {
    System.out.println(LocalTime.now() + " (" + Thread.currentThread().getName() + ") " + msg);
  }

  // 유향 계산 테스트
  public static double getCurrentDirect(double u, double v) {
    double ang = 0;
    double arctan = (Math.atan2(v, u) - ang) * 180 / Math.PI;
    arctan = arctan * -1 + 90;
    if (arctan < 0) {
      arctan = arctan + 360;
    }
    return (Math.round(arctan * 100d) / 100d);
  }

  // 유속 계산 테스트
  public static double getCurrentSpeed(double u, double v) {
    double u2 = Math.pow(u, 2);
    double v2 = Math.pow(v, 2);
    if (u2 == Double.NaN) {
      u2 = 0.0;
    }
    if (v2 == Double.NaN) {
      v2 = 0.0;
    }
    double speed = Math.sqrt(u2 + v2);
    return round((Math.round(speed * 100d) / 100d));
  }

  static double round(double d) {
    int n = 2;
    return (d < -1000) ? 0 : Math.round(d * Math.pow(10, n)) / Math.pow(10, n);
  }

  /**
   * Stream에서 distinct 다중키 비교를 위함 (hashCode, equals 재정의를 하지 않고)
   * list.stream().filter(distinctByKeys(UserVO::getName, UserVO::getAge)).distinct()...
   *
   * @param keyExtractors Object[]
   * @return Predicate
   */
  public static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
    final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();
    return t -> {
      final List<?> keys =
          Arrays.stream(keyExtractors).map(ke -> ke.apply(t)).collect(Collectors.toList());
      return seen.putIfAbsent(keys, Boolean.TRUE) == null;
    };
  }
}
