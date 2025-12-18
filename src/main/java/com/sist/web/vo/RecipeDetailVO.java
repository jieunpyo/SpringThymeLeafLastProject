package com.sist.web.vo;

import lombok.Data;

/*
 *   NO              NUMBER(38)     
POSTER          VARCHAR2(4000) 
TITLE           VARCHAR2(4000) 
CHEF            VARCHAR2(4000) 
CHEF_POSTER     VARCHAR2(4000) 
CHEF_PROFILE    VARCHAR2(4000) 
INFO1           VARCHAR2(26)   
INFO2           VARCHAR2(26)   
INFO3           VARCHAR2(26)   
CONTENT         VARCHAR2(4000) 
FOODMAKE        VARCHAR2(4000)
 */
@Data
public class RecipeDetailVO {
  private int no;
  private String poster,title,chef,chef_profile,chef_poster,
          info1,info2,info3,content,foodmake;
}