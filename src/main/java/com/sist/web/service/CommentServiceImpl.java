package com.sist.web.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@Service // BI => 여러개 DAO 통합해서 사용,SQL문장 통합
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
   // 필요한 객체를 스프링으로부터 가지고 온다 => @Autowired / getBean()
   // private 변수에 접근이 가능 (OOP를 무시) => 가급적이면 생성자에서 값을 주입
   // 리플렉션 Class.forName() 
   private final CommentMapper mapper;

   @Override
   public List<CommentVO> commentListData(int cno, int type) {
	// TODO Auto-generated method stub
	 return mapper.commentListData(cno,type);
   }

   @Override
   public void commentInsert(CommentVO vo) {
	// TODO Auto-generated method stub
	 mapper.commentInsert(vo);
   }

   @Override
   public void commentDelete(int no) {
	// TODO Auto-generated method stub
	 mapper.commentDelete(no);
   }

   @Override
   public void commentUpdate(int no, String msg) {
	// TODO Auto-generated method stub
	mapper.commentUpdate(no, msg);
   }
   // 수정 
}