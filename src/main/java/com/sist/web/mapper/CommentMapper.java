package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
@Mapper
@Repository
public interface CommentMapper {
  // 목록 
  @Select("SELECT no,cno,type,id,name,msg,"
  		+ "TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday "
		+"FROM comment_1 "
  		+"WHERE cno=#{cno} AND type=#{type} "
	    +"ORDER BY no DESC")
  public List<CommentVO> commentListData(@Param("cno") Integer cno,
		  @Param("type") Integer type);
  // 추가
  // SEQUENCE => before : 먼저 수행 
  @SelectKey(keyProperty = "no",resultType = int.class,before = true,
		  statement = "SELECT NVL(MAX(no)+1,1) FROM comment_1")
  @Insert("INSERT INTO comment_1 VALUES("
		 +"#{no},#{cno},#{type},#{id},#{name},#{msg},SYSDATE)")
  public void commentInsert(CommentVO vo);
  // 수정 
  // 삭제 
  @Delete("DELETE FROM comment_1 "
		 +"WHERE no=#{no}")
  public void commentDelete(int no);
}