package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.RecipeService;
import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;

// 브라우저로 전송 => 
/*
 *    HttpServletRequest 
 *    
 *    => 클래스 캡슐화 
 *    class Model 
 *    {
 *       @Autowired
 *       HttpServletRequest request; => DispatcherServlet
 *       public void addAttribute(String key, Object obj)
 *       {
 *           request.setAttribute(key,obj);
 *       }
 *       
 *    }
 *    -------------------- 
 *    @Controller 
 *    @RestController 
 *    -------------------- DispatcherServlet => 사용은 
 */
@Controller
@RequestMapping("/recipe/")
@RequiredArgsConstructor
/*
 *  한개 page=1 @RequestParam("page")
 *  VO 단위  => @ModelAttribute("vo")
 *  {       => JSON => 객체로 변환 @RequestBody
 *    no:1,
 *    name:''
 *  }
 *  
 *  @ResponseBody @RestController  메소드 => 클래스단위 
 *      |              |
 *      ----------------
 *        | 다른 언어로 값을 전송 
 *  메소드 => 승격 => 연산자 
 *   free() / malloc()
 *     |        |
 *    delete   new 
 *    
 *  XML => 변경 (어노테이션) 
 *   | 자바스크립트 : JSON 
 */
public class RecipeController {
   private final RecipeService rService;
   
   @GetMapping("list")
   public String recipe_list(
		   @RequestParam(name="page",required = false) String page,
		   Model model)
   {
	        if(page==null)
	   		  page="1";
		   	int curpage=Integer.parseInt(page);// 현재 페이지
		   	// 현재 페이지의 데이터 읽기
		   	int start=(curpage-1)*12;
		   	
		   	List<RecipeVO> list=rService.recipeListData(start);
		   	// 0 , 12, 24...
		   	// 총페이지 읽기
		   	int totalpage=rService.recipeTotalPage();
		   	
		   	final int BLOCK=10;
		   	int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   	
		   	if(endPage>totalpage)
		   		endPage=totalpage;
		   	
		   	model.addAttribute("list", list);
		   	model.addAttribute("curpage", curpage);
		   	model.addAttribute("totalpage", totalpage);
		   	model.addAttribute("startPage", startPage);
		   	model.addAttribute("endPage", endPage);
		    model.addAttribute("main_html", "recipe/list");
	   return "main/main";
   }
   @GetMapping("detail")
   public String recipe_detail(@RequestParam("no") int no, Model model)
   {
	   // DB 연동 
	   RecipeDetailVO vo=rService.recipeDetailData(no);
	   model.addAttribute("vo", vo);
	   // 댓글 
	   model.addAttribute("main_html", "recipe/detail");
	   return "main/main";
   }
   @GetMapping("chef_list")
   public String recipe_chef_list(
		   @RequestParam(name="page",required = false) String page,
		   @RequestParam("chef") String chef,Model model)
   {
	   // DB 연동 
	   if(page==null)
	   		  page="1";
		   	int curpage=Integer.parseInt(page);// 현재 페이지
		   	// 현재 페이지의 데이터 읽기
		   	int start=(curpage-1)*12;
		   	
		   	List<RecipeVO> list=rService.recipeChefListData(start, chef);
		   	// 0 , 12, 24...
		   	// 총페이지 읽기
		   	int totalpage=rService.recipeChefTotalPage(chef);
		   	
		   	final int BLOCK=10;
		   	int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   	
		   	if(endPage>totalpage)
		   		endPage=totalpage;
		   	
		   	model.addAttribute("list", list);
		   	model.addAttribute("curpage", curpage);
		   	model.addAttribute("totalpage", totalpage);
		   	model.addAttribute("startPage", startPage);
		   	model.addAttribute("endPage", endPage);
		   	model.addAttribute("chef", chef);
	   model.addAttribute("main_html", "recipe/chef_list");
	   return "main/main";
   }
}