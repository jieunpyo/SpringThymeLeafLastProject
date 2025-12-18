package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.mapper.*;
@Service
@RequiredArgsConstructor
/*
 *    @Autowired
 *    public SeoulServiceImpl(SeoulMapper mapper)
 *    {
 *       this.mapper=mapper;
 *    }
 */
public class SeoulServiceImpl implements SeoulService{
   private final SeoulMapper mapper;

   @Override
   public List<SeoulVO> seoulMainData(Map map) {
	// TODO Auto-generated method stub
	 return mapper.seoulMainData(map);
   }

   @Override
   public List<SeoulVO> seoulListData(Map map) {
	// TODO Auto-generated method stub
	return mapper.seoulListData(map);
   }

   @Override
   public int seoulTotalPage(Map map) {
	// TODO Auto-generated method stub
	return mapper.seoulTotalPage(map);
   }

   @Override
   public SeoulVO seoulDetailData(Map map) {
	// TODO Auto-generated method stub
	   mapper.seoulHitIncrement(map);
	   return mapper.seoulDetailData(map);
   }

   @Override
   public List<FoodVO> seoulNearFoodHouse(String address) {
	// TODO Auto-generated method stub
	return mapper.seoulNearFoodHouse(address);
   }
}