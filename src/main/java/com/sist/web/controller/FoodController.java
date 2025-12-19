package com.sist.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
// SI / SM / SE => devops 
// => AI 
public class FoodController {
    private final FoodService fService;
    
    @GetMapping("/food/list")
    public String food_list(
    		@RequestParam(name="page",required = false) String page,
    		Model model)    
    {
    	if(page==null)
    		page="1";
    	int curpage=Integer.parseInt(page);// 현재 페이지
    	// 현재 페이지의 데이터 읽기
    	int start=(curpage-1)*12;
    	List<FoodVO> list=fService.foodListData(start);
    	// 0 , 12, 24...
    	// 총페이지 읽기
    	int totalpage=fService.foodTotalPage();
    	
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
    	// include 
    	model.addAttribute("main_html", "food/list");
    	
    	return "main/main";
    }
    /*
     *   SpringBoot (SpringFramework)
     *   브라우저 <=> Controller <==> Service <=> Mapper <=> 오라클
     */
    @GetMapping("/food/detail")
    public String food_detail(@RequestParam("fno") int fno,Model model,
    		HttpSession session)
    {
    	FoodVO vo=fService.foodDetailData(fno);
    	String id=(String)session.getAttribute("id");
    	if(id==null)
    	{
    		model.addAttribute("sessionId", "");
    	}
    	else
    	{
    		model.addAttribute("sessionId", id);
    	}
    	model.addAttribute("vo", vo);
    	model.addAttribute("main_html", "food/detail");
    	return "main/main";
    }
}