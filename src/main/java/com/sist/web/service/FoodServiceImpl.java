package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
   private final FoodMapper mapper;

   @Override
   public List<FoodVO> foodListData(int start) {
	// TODO Auto-generated method stub
	return mapper.foodListData(start);
   }

   @Override
   public int foodTotalPage() {
	// TODO Auto-generated method stub
	return mapper.foodTotalPage();
   }

   @Override
   public List<FoodVO> foodTop10Data() {
	// TODO Auto-generated method stub
	return mapper.foodTop10Data();
   }

   @Override
   public FoodVO foodDetailData(int fno) {
	// TODO Auto-generated method stub
	   mapper.foodHitIncrement(fno);
	   return mapper.foodDetailData(fno);
   }
}
