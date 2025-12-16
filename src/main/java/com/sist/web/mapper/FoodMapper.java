package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
@Repository
public interface FoodMapper {
   @Select("SELECT fno,name,poster "
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
}
