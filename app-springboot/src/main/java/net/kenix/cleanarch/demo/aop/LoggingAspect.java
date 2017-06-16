/*
* Created at 23:10 on 16.06.17
*/
package net.kenix.cleanarch.demo.aop;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging execution of service and repository Spring components.
 *
 * By default, it only runs with the "dev" profile.
 */
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@Slf4j
@Aspect
@Component
public class LoggingAspect {

  private final Environment env;

  /**
   * Pointcut that matches all repositories, services and Web REST endpoints.
   */
  @Pointcut("within(net.kenix.cleanarch.demo.web..*) || within(net.kenix.cleanarch.demo..*) ")
  public void loggingPointcut() {
    // Method is empty as this is just a Pointcut, the implementations are in the advices.
  }

  /**
   * Advice that logs methods throwing exceptions.
   *
   * @param joinPoint join point for advice
   * @param e exception
   */
  @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
    if (env.acceptsProfiles("dev")) {
      log.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'",
          joinPoint.getSignature().getDeclaringTypeName(),
          joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL",
          e.getMessage(), e);

    } else {
      log.error("Exception in {}.{}() with cause = {}",
          joinPoint.getSignature().getDeclaringTypeName(),
          joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }
  }

  /**
   * Advice that logs when a method is entered and exited.
   *
   * @param joinPoint join point for advice
   * @return result
   * @throws Throwable throws IllegalArgumentException
   */
  @Around("loggingPointcut()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    if (log.isDebugEnabled()) {
      log.debug("Enter: {}.{}() with argument[s] = {}",
          joinPoint.getSignature().getDeclaringTypeName(),
          joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }
    try {
      Object result = joinPoint.proceed();
      if (log.isDebugEnabled()) {
        log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(), result);
      }
      return result;
    } catch (IllegalArgumentException e) {
      log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
          joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

      throw e;
    }
  }
}

