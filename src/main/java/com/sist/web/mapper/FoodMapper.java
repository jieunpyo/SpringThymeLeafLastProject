package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
@Repository
public interface FoodMapper {
   @Select("SELECT fno,name,poster,hit "
		  +"FROM menupan_food "
		  +"ORDER BY fno ASC "
		  +"OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
   public List<FoodVO> foodListData(int start);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
   public int foodTotalPage();
   
   // Footer에 출력 
   @Select("SELECT fno,name,rownum "
		  +"FROM (SELECT fno,name "
		  +"FROM menupan_food "
		  +"ORDER BY hit DESC) "
		  +"WHERE rownum<=10")
   public List<FoodVO> foodTop10Data();
   
   // HIT 증가
   @Update("UPDATE menupan_food SET "
		  +"hit=hit+1 "
		  +"WHERE fno=#{fno}")
   public void foodHitIncrement(int fno);
   // 상세보기 데이터 읽기 
   @Select("SELECT * FROM menupan_food "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
}