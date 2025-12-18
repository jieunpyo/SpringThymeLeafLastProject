package com.sist.web.aop;
import java.util.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
@Aspect // 공통모듈 => 모든 HTML에 공통으로 적용 
@Component // 관리 => 스프링에서 처리
@RequiredArgsConstructor
/*
 *    AOP적용 => JoinPoint / PointCut
 *                          어떤 메소드인지 
 *              메소드 어느 영역인지 
 *              
 *              public String aaa()
 *              {
 *                @Before
 *                try
 *                {
 *                     ---------- @Around(first) => setAutoCommit(false)
 *                     
 *                     ---------- @Around(last) => commit 
 *                }catch(Exception e)
 *                {
 *                   @After-Throwing  => rollback()
 *                }
 *                finally
 *                {
 *                   @After
 *                }
 *                return "" @After-Returning 
 *              }
 *              해당 메소드를 한번에 통합해서 => 호출 
 *              ---------------------- 위빙
 *              
 *              @After  @Before  @After-Throwing 
 *              after() before() afterthrowing()
 *              
 *              public void aaa()
 *              {
 *                before()
 *                try
 *                {
 *                   ----
 *                   ----
 *                }catch(Exceptio e)
 *                {
 *                   afterthrowing() 
 *                }
 *                finally
 *                {
 *                   after()
 *                }
 *              }
 *              
 *              대신 => 프록시 패턴 (대리자)
 */
public class FooterAOP {
	// FoodController => fService 동일하다 (싱글턴으로 저장)
    private final FoodService fService;
    private final RecipeService rService;
    
    @After("execution(* com.sist.web.controller.*Controller.*(..))")
    public void after()
    {
    	HttpServletRequest request=
    		((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	List<FoodVO> fList=fService.foodTop10Data();
    	request.setAttribute("fList", fList);
    	List<RecipeVO> rList=rService.recipeTop10();
    	request.setAttribute("rList", rList);
    }
    
    
}