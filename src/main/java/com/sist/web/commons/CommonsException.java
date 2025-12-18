package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @Controller에서 발생 예외를 처리 = 공통 기반 
@ControllerAdvice
public class CommonsException {
   // 예외만 가능 => 수정이 가능한 에러 
   @ExceptionHandler(Exception.class)
   public void exception(Exception ex)
   {
	   System.out.println("============= Exception 발생 ========");
	   ex.printStackTrace();
   }
   // 예외 + 에러 (수정이 불가능한 에러)
   @ExceptionHandler(Throwable.class)
   public void throwable(Throwable ex)
   {
	   System.out.println("============= Throwable 발생 ========");
	   ex.printStackTrace();
   }
}