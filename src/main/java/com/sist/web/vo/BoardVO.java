package com.sist.web.vo;
import java.util.*;
// 목록 / 상세보기 
public interface BoardVO {
  public int getNo();
  public String getName();
  public String getSubject();
  public String getContent();
  public String getDbday();
  public Date getRegdate();
  public int getHit();
  public int getNum();
}
