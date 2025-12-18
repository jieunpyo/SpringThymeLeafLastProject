
package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.sist.web.vo.*;
import java.util.*;
/*
 *  집합연산자 
 *    A
 *     1 2 3 4 5
 *    B
 *     4 5 6 7 8
 *    = UNION ==========> 1 2 3 4 5 6 7 8
 *    = UNION ALL ======> 1 2 3 4 5 4 5 6 7 8
 *    = INTERSECT ======> 4 5
 *    = MINUS ====> A-B ===> 1 2 3 
 *                  B-A ===> 6 7 8
 *    ====> JOIN : INTERSECT (inner join) = equlas_join
 *    ====> Outer JOIN : LEFT : INTERSECT + MINUS A-B
 *                       RIGHT : INTERSECT + MINUS B-A
 *                       
 *      
 */
@Mapper
@Repository
public interface RecipeMapper {
  @Select("SELECT no,poster,title,chef "
		 +"FROM recipe "
		 +"WHERE no IN(SELECT no FROM recipe "
		 +"INTERSECT SELECT DISTINCT no FROM recipedetail) "
		 +"ORDER BY no ASC "
		 +"OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
  public List<RecipeVO> recipeListData(int start);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
		  +"WHERE no IN(SELECT no FROM recipe "
		  +"INTERSECT SELECT DISTINCT no FROM recipedetail)")
  public int recipeTotalPage();
  
  @Update("UPDATE recipe SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void recipeHitIncrement(int no);
  @Select("SELECT * FROM recipedetail "
		 +"WHERE no=#{no}")
  public RecipeDetailVO recipeDetailData(int no);
  
  @Select("SELECT no,title,hit,chef,rownum "
		 +"FROM (SELECT no,title,hit,chef "
		 +"FROM recipe ORDER BY hit DESC) "
		 +"WHERE rownum<=10")
  public List<RecipeVO> recipeTop10();
  
     @Select("SELECT no,poster,title,chef "
			 +"FROM recipe "
			 +"WHERE REGEXP_LIKE(chef,#{chef}) "
			 +"ORDER BY no ASC "
			 +"OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	  public List<RecipeVO> recipeChefListData(
			  @Param("start") int start,
			  @Param("chef") String chef
			 );
     @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
   		  +"WHERE REGEXP_LIKE(chef,#{chef})")
     public int recipeChefTotalPage(String chef);
}
