package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

public interface RecipeService {
	public List<RecipeVO> recipeListData(int start);
	public int recipeTotalPage();
	public RecipeDetailVO recipeDetailData(int no);
}
