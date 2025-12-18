package com.sist.web.service;

import java.util.List;
import java.util.Map;

import com.sist.web.vo.SeoulVO;

public interface SeoulService {
	public List<SeoulVO> seoulMainData(Map map);
	public List<SeoulVO> seoulListData(Map map);
	public int seoulTotalPage(Map map);
	public SeoulVO seoulDetailData(Map map);
}
