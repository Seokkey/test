// package kr.ust21.kiost.coast.sts.service;
//
// import kr.ust21.kiost.coast.sts.domain.dto.StsSysLogDto;
// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.aspectj.lang.reflect.MethodSignature;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;
// import org.springframework.util.StopWatch;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.context.request.RequestContextHolder;
// import org.springframework.web.context.request.ServletRequestAttributes;
// import lombok.extern.slf4j.Slf4j;
//
// import javax.servlet.http.HttpServletRequest;
//
// @Aspect
// @Slf4j
// @Component
// public class StsSysLogManageAspect {
//
//   //@Resource(name="StsSysLogService")
//   private StsSysLogService stsSysLogService;
//
//   //@Pointcut("execution(* kr.ust21.kiost.coast.*.web.*Controller.insert*(..))")
//   //@Pointcut("execution(* kr.ust21.kiost.coast.*.web.insert*(..))")
//   //@Pointcut("execution( * *..*Controller.insert*(..) )")
//   //@Pointcut("@target(org.springframework.web.bind.annotation.RestController)")
//   //@Pointcut("execution(* kr.ust21.kiost.coast.*.*Controller.insert*(..))")
//   //    @Pointcut("execution(* kr.ust21.kiost.coast.*.web.*.insert*(..) )")
//   //@Pointcut("execution(* kr.ust21.kiost.coast.*.web.*.*(..) )")
//   //@Pointcut("within(kr.ust21.kiost.coast.*.*Controller.insert*(..))")
//   //    @Pointcut("bean(RestController)")
//   //    @Pointcut("bean(RequiredArgsConstructor)")
//   //    @Pointcut("execution(* kr.ust21.kiost.coast..web.*Controller.*(..))")
//   //@Pointcut("bean(*Controller)")
//   //@Pointcut("execution(* *(..))")
//
//
//   /** 포인트 컷 등록(Spring Annotation) */
//   //@Pointcut("within(@org.apache.ibatis.annotations.Mapper *)" +
//   //" || within(@org.springframework.stereotype.Service *)" + " || within(@org.springframework.web.bind.annotation.RestController *)")
//
//   //@Pointcut("within(kr.ust21.kiost.coast..mapper..*)"
//   //+ " || within(kr.ust21.kiost.coast..service..*)"
//   //+ " || within(kr.ust21.kiost.coast..web..*)")
//   //@Pointcut("execution()")
//   //public void springBeanPointcut() {
//   //}
//
//   //@Around("springBeanPointcut()")
//   //    public Object logInsert(ProceedingJoinPoint joinPoint) throws Throwable {
//   //        StopWatch stopWatch = new StopWatch();
//   //        LocalDateTime occrDt = LocalDateTime.now(); //발생일시
//   //        Integer rspnsCd = null;
//   //        String errorNm = null;
//   //        String errorCnDtl = null;
//   //        Class tmpClass = joinPoint.getTarget().getClass();
//   //        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//   //        String urlString = request.getRequestURI(); //url candidate
//   //
//   //        try {
//   //            stopWatch.start();
//   //            Object retValue = joinPoint.proceed();
//   //            rspnsCd = ((ResponseEntity) retValue).getStatusCodeValue(); //응답코드 (HTTP 상태코드)
//   //            return retValue;
//   //        } catch (Throwable e) {
//   //            errorNm = e.getClass().getCanonicalName(); //오류명
//   //            errorCnDtl = e.getMessage(); //오류내용상세
//   //            throw e;
//   //        } finally {
//   //            stopWatch.stop();
//   //            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//   //            String userId = authentication.getPrincipal().toString(); //사용자ID -> 이게 토큰일수도 있음
//   //            String url = getRequestUrl(joinPoint, tmpClass); //url
//   //            String svcNm = joinPoint.getTarget().getClass().getName(); //서비스명
//   //            //String svcNm = joinPoint.getSignature().getDeclaringTypeName(); //서비스명 혹시 안된다면 이거
//   //            String mthdNm = joinPoint.getSignature().getName(); //메소드명
//   //            String hdgSeCd = Character.toString(mthdNm.charAt(0)).toUpperCase(); //처리구분코드
//   //
//   //            Long ms = stopWatch.getTotalTimeMillis();
//   //            Integer hdgHhs = ms.intValue(); //처리시간(MS)
//   //            StsSysLogDto.ReqInsert dto = StsSysLogDto.ReqInsert.builder()
//   //                    .occrDt(occrDt).userId(userId).url(url).svcNm(svcNm)
//   //                    .mthdNm(mthdNm).hdgSeCd(hdgSeCd).hdgHhs(hdgHhs)
//   //                    .rspnsCd(rspnsCd).errorNm(errorNm).errorCnDtl(errorCnDtl).build();
//   //            stsSysLogService.insert(dto);
//   //        }
//   //    }
//
//   //@Pointcut("execution(* kr.ust21.kiost.coast.*.*Service.*(..))")
//   //@Pointcut("execution(* *(..))")
//   //    @Pointcut("execution(* kr.ust21.kiost.coast.sts.service.impl..*(..))")
//   //    @Pointcut("within(@lombok.RequiredArgsConstructor *)")
//   //    @Pointcut("execution(* *(..))")
//   //    @Pointcut("within(kr.ust21.kiost.coast..service.impl..*)")
//   @Pointcut("within(@org.apache.ibatis.annotations.Mapper *)" +
//       " || within(@org.springframework.stereotype.Service *)" + " || within(@org.springframework.web.bind.annotation.RestController *)")
//   public void servicePointcut() {
//   }
//
//   @Before("servicePointcut()")
//   public void beforeTargetMethod(JoinPoint joinPoint) {
//     System.out.println("print before~~~~~~");
//   }
//
//   @Around("servicePointcut()")
//   //    @Around("within(kr.ust21.kiost.coast..service.impl..*)")
//   //    @Around("within(kr.ust21.kiost.coast..service..*)")
//   //@Around("within(@org.apache.ibatis.annotations.Mapper *)" +
//   //" || within(@org.springframework.stereotype.Service *)" + " || within(@org.springframework.web.bind.annotation.RestController *)")
//   public Object serviceLogInsert(ProceedingJoinPoint joinPoint) throws Throwable {
//     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//     String userId = authentication.getPrincipal().toString(); //사용자ID -> 이게 토큰일수도 있음
//     log.debug("TEST!!!!!!!!!!!!!!!!   print servicepointcut BEFORE PROCEED");
//     System.out.println("print servicepointcut BEFORE PROCEED");
//     System.out.println("print servicepointcut userID = " + userId);
//
//     try {
//
//       Object ret = joinPoint.proceed();
//       System.out.println("print servicepointcut ret.getClass.getSimpleName = " + ret.getClass().getSimpleName());
//
//       System.out.println("print servicepointcut DURING PROCEED");
//       return ret;
//     } catch (Throwable e) {
//       System.out.println("print servicepointcut EXCEPTION OCCURED");
//       System.out.println("print servicepointcut e.getClass = " + e.getClass());
//       System.out.println("print servicepointcut e.getMessage = " + e.getMessage());
//       throw e;
//     } finally {
//       System.out.println("print servicepointcut FINALLY");
//       System.out.println("print servicepointcut servicename = " + joinPoint.getTarget().getClass().getName());
//       System.out.println("print servicepointcut methodname = " + joinPoint.getSignature().getName());
//       System.out.println("print servicepointcut methodname to long string = " + joinPoint.getSignature().toLongString());
//     }
//   }
// }