package com.sist.web.entity;
/*
 * 	 NO      NOT NULL NUMBER         
NAME    NOT NULL VARCHAR2(51)   
SUBJECT NOT NULL VARCHAR2(4000) 
CONTENT NOT NULL CLOB           
PWD     NOT NULL VARCHAR2(10)   
REGDATE          DATE           
HIT              NUMBER  

 */
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
// save()  ,  delete()
// findByNo(int no) WHERE no=1
// findByName(String name)
// findByNameLike
// 단점 : JOIN / SubQuery를 지원하지 않는다
@Data
@Entity(name="board_1")
public class BoardEntity {
    @Id
	private int no;
    
    private int hit;
    private String name,subject,content,pwd;
    private Date regdate;
}


