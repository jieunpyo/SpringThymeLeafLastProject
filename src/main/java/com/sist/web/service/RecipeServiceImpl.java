
package com.sist.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *                                                      
 *   VO ==> Mapper (SQL) ==> Service에서 구현  ======> Controller =====> HTML/JSP
 *             |                 |                      |
 *                                               데이터베이스에서 읽은 값을 브라우저
 *                                                      | Spring에서 처리
 *                                                        @Controller
 *                                                          | ThymeLeaf/ JSP
 *                                                          | router
 *                                                          | return ""
 *                                                      | Spring에서 데이터 전송
 *                                                        @RestController 
 *                                                          | Vue / React / Next
 *                                                      => JS / TS 
 *                                                         --------
 *                                                          일반 데이터형은 동일 
 *                                                          Object / Array
 *                                                                   | List => []
 *                                                          | VO , Map => {}
 *                                                                  | []
 *           class A
 *           {
 *              int no; 
 *              String name,sex,address;
 *           }
 *           TS
 *           interface A => type A
 *           {
 *               no:int,
 *               name:string
 *               sex:string
 *               address:string 
 *           } 
 *           JS
 *           {no:1,name:'',sex:'',address:''} => JSON
 *           [{},{},{}...]
 *           
 *           순수하게 SQL       SQL여러개 모아서 하나의 기능 수행
 *                            => hitIncrement
 *           
 */
import java.util.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.mapper.*;
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{
    private final RecipeMapper mapper;

	@Override
	public List<RecipeVO> recipeListData(int start) {
		// TODO Auto-generated method stub
		return mapper.recipeListData(start);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return mapper.recipeTotalPage();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}

	@Override
	public List<RecipeVO> recipeTop10() {
		// TODO Auto-generated method stub
		return mapper.recipeTop10();
	}

	@Override
	public List<RecipeVO> recipeChefListData(int start, String chef) {
		// TODO Auto-generated method stub
		return mapper.recipeChefListData(start, chef);
	}

	@Override
	public int recipeChefTotalPage(String chef) {
		// TODO Auto-generated method stub
		return mapper.recipeChefTotalPage(chef);
	}
    
    
}
