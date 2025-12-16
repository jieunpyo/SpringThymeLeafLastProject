package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.mapper.*;
@Service
@RequiredArgsConstructor
/*
 * 	 @Autowired
 * 	 public SeoulServiceImpl(SeoulMapper mapper)
 * 	 {
 * 		this.mapper=mapper;
 * 	 }
 */
public class SeoulServiceImpl implements SeoulService{
   private final SeoulMapper mapper;

   @Override
   public List<SeoulVO> seoulMainData(Map map) {
	// TODO Auto-generated method stub
	 return mapper.seoulMainData(map);
   }
}
