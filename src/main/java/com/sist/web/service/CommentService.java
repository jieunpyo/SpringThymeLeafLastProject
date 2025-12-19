package com.sist.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sist.web.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> commentListData(int cno,int type);
	public void commentInsert(CommentVO vo);
	public void commentDelete(int no);
}