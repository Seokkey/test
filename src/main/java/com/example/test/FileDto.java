package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class FileDto {
  @Getter
  @Setter
  @Builder(toBuilder = true)
  @AllArgsConstructor
  @ToString
  public static class Req {
    @NotNull private Integer mtrSn;

    @NotNull private LocalDateTime mtrPrdtDt;

    @NotNull private String mtrTyCd;

    @NotNull private String mtrSttCd;

    @NotNull private String filePth;

    @NotNull private String fileNm;

    @NotNull private Long fileCpc;

    @NotNull private String fileExsn;

    @NotNull private LocalDateTime fileUpdtDt;

    @NotNull private String fileChecksum;
  }

  @Getter
  @ToString
  @AllArgsConstructor
  public static class Res {
    private Integer mtrSn;

    private LocalDateTime mtrPrdtDt;

    private String mtrTyCd;

    private String mtrSttCd;

    private String filePth;

    private String fileNm;

    private Long fileCpc;

    private String fileExsn;

    private LocalDateTime fileUpdtDt;

    private String fileChecksum;

    private LocalDateTime creatDt;
  }
}
