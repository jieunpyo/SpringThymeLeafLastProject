package com.sist.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

public interface RecipeService {
	public List<RecipeVO> recipeListData(int start);
	public int recipeTotalPage();
	public RecipeDetailVO recipeDetailData(int no);
	public List<RecipeVO> recipeTop10();
	public List<RecipeVO> recipeChefListData(int start,String chef);
	public int recipeChefTotalPage(String chef);
}