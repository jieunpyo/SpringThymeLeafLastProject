package com.sist.web.service;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.*;
@Service
@RequiredArgsConstructor // 객체 주소 주입 => DI
public class MemberServiceImpl implements MemberService{
   private final MemberMapper mapper;

   @Override
   public MemberVO memberLogin(String id, String pwd) {
	  // TODO Auto-generated method stub
	  MemberVO vo=new MemberVO();
	  int count=mapper.memberIdCount(id);
	  if(count==0)
	  {
		  vo.setMsg("NOID");
	  }
	  else
	  {
		  MemberVO dbVO=mapper.memberInfoData(id);
		  if(pwd.equals(dbVO.getPwd()))
		  {
			  vo=dbVO;
			  vo.setMsg("OK");
			  
		  }
		  else
		  {
			  vo.setMsg("NOPWD");
		  }
	  }
	  return vo;
   }
   
   
}