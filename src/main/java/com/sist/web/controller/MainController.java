package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * 	 ThymeLeaf
 * 	 ---------
 * 	  서버사이드 템플릿 엔진 (SSR)
 * 	  
 * 	  1. 서버에서 HTML을 완성해서 => 브라우저로 전송
 * 	  2. 초기 로딩 속도가 빠르다 / 보안에 유리 
 * 	  3. JSP를 대체하기 위한 기술 
 * 	     --- STS : 3.9.18 마지막까지만 JSP를 지원 
 * 				   => JSP를 지원하지 않는다 
 * 				   => JSP는 유지보수만 생존 
 * 		 --- VueJS / ReactJS => 속도 (AI를 대체 => 5G)
 * 					 ------- 50% 
 * 		 서버
 * 		  | Spring-Boot (security / batch / AI) 
 * 		  | NodeJS 
 * 	  4. 프로젝트 구조 
 * 		 src/main/resource 
 * 			  |
 * 		   templates
 * 			  |
 * 			 main => html (layout)
 * 			 food
 * 			 board
 * 			 seoul 
 * 		   static
 * 			  | 정적 폴더 => js / css / image 
 * 	   5. 출력 
 * 		   | 제어문 / 출력문 
 * 			 | th:each="변수:${collection}"
 * 			   th:if="조건문"
 * 			   th:else=""
 * 			   th:text="" => <>[[${변수}]]<>
 * 			   -----------
 * 				| th: utext="" => html을 파싱후에 출력 
 * 		   	 | index , count , size 
 * 			 | even odd 
 * 			 | first / last 
 * 		   | 링크
 * 			 <a th:href="@{경로명(전송할 데이터)}">
 * 						 @{/food/list(page=1,fno=1)}
 * 			 <script th:src="@{/js/app.js}">
 * 			 
 * 		   | 속성 
 * 			 <input type=text th:value="${값}">
 * 			 <img th:src="@{$파일}">
 * 		   | layout
 * 		     <th:block th:include="|">
 * 								  변수
 * 			 <div th:fragment="header">
 * 		   | Form
 * 			 <form th:action="@{/user}">
 * 		   | 서버 Controller에서 전송 
 * 			 return "폴더/파일명"; => forward => request를 전송 
 * 			 return "redirect:/" => sendRedirect => request 전송이 없는 경우
 * 		   | security 
 * 			 <div sec:authoize="isAuthoize()">
 * 				  ---- security태그 
 * 			 => 보안 : session 기반 / cookie 기반 
 * 					  | 일반 보안		| JWT (권장) 
 * 		   | Vue => delimiter="(())"
 * 
 * 		   | 자주 오류 발생
 * 			 favicon.ico 
 * 
 * 		    ${} => EL
 * 			#{} => numbers
 * 			@{} => link => 파일 읽기 
 * 
 * 			===> 화면 UI => 항상 태그안에서 속성으로 처리 (vue) 
 * 						   태그밖에서 처리 : JSP / React
 * 		    ===> CI/CD : Git Actions
 * 							 |
 * 						  Docker => Docker Hub
 * 							 |
 * 						  Docker-Compose 
 * 							 |
 * 						  MiniKube : 우분투 
 * 							 |
 * 						  Jenkins 
 * 			
 * 
 */
import java.util.*;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class MainController {
   private final SeoulService sService;
   @GetMapping("/")
   public String main_page(Model model)
   {
	   Map map=new HashMap();
	   map.put("table_name", "seoul_location");
	   List<SeoulVO> lList=sService.seoulMainData(map);
	   
	   map=new HashMap();
	   map.put("table_name", "seoul_nature");
	   List<SeoulVO> nList=sService.seoulMainData(map);
	   
	   map=new HashMap();
	   map.put("table_name", "seoul_shop");
	   List<SeoulVO> sList=sService.seoulMainData(map);
	   
	   // main에 전송 
	   model.addAttribute("lList", lList);
	   model.addAttribute("sList", sList);
	   model.addAttribute("nList", nList);
	   
	   model.addAttribute("main_html", "main/home");
	   return "main/main";
   }
}
