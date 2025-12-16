package com.sist.web.vo;

import lombok.Data;

/*
 * 	FNO           NUMBER(38)     
	NAME          VARCHAR2(4000) 
	TYPE          VARCHAR2(4000) 
	PHONE         VARCHAR2(26)   
	ADDRESS       VARCHAR2(4000) 
	SCORE         NUMBER(38,1)   
	THEME         VARCHAR2(4000) 
	PRICE         VARCHAR2(26)   
	TIME          VARCHAR2(128)  
	PARKING       VARCHAR2(128)  
	POSTER        VARCHAR2(4000) 
	IMAGES        VARCHAR2(4000) 
	CONTENT       VARCHAR2(4000) 
	HIT           NUMBER(38)     
	JJIMCOUNT     NUMBER(38)     
	LIKECOUNT     NUMBER(38)     
	REPLYCOUNT    NUMBER(38) 
	
 */
@Data
public class FoodVO {
  private int fno,git,jjimcount,likecount,replycount;
  private String name,address,phone,theme,type,price,time,
  		  parking,poster,images,content;
  private double score;
}
