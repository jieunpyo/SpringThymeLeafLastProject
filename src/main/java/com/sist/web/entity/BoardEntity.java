package com.sist.web.entity;
/*
 *   NO      NOT NULL NUMBER         
NAME    NOT NULL VARCHAR2(51)   
SUBJECT NOT NULL VARCHAR2(4000) 
CONTENT NOT NULL CLOB           
PWD     NOT NULL VARCHAR2(10)   
REGDATE          DATE           
HIT              NUMBER         

 */
import java.util.*;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
// save()  ,  delete()
// findByNo(int no) WHERE no=1 
// findByName(String name) 
// findByNameLike
// 단점 : JOIN / SubQuery를 지원하지 않는다
/*
 *   1월 : security (jwt)/ sns 연동 
 *         websocket / 통합 / AI / betch 
 *        ------------------------------
 *        => boot : 실무 
 *        ------------------------------ 
 */
/*
 *    1. JPA (Java persistence API)
 *       1) JAVA ORM(Object Relational Mapping)의 표준 
 *                          ---------- 관계형 데이터베이스
 *                          = MyBatis 
 *                          = Hibernate (JPA)
 *       2) 자바 객체와 데이터베이스 테이블 매핑 
 *          -------  ------------------
 *            |           |
 *            -------------
 *             변수 / 컬럼명과 반드시 일치 => update , insert
 *             INSERT INTO table(변수명) ....
 *             VO / DTO => 유연성 
 *             Entity = 반드시 컬럼면과 일치 : JOIN => CRUD 
 *       3) 특별한 경우가 아니면 SQL없이 사용이 가능 => DB연동 
 *          --------- 6:4 = select 문장 (SQL) , insert/update/delete
 *                                             =============
 *                                              save()  , delete()
 *       4) ORM 
 *          => JDBC = DBCP = ORM (MyBatis / JPA)
 *             select * from table_name 
 *             findAll() => SQL 
 *          => native SQL / JPQL => 변수와 매칭  
 *          => 객체(BoardEntity) = 테이블 자동 매핑 
 *             => BoardEntiry (X) => Board
 *             = 필드 <=> 컬럼
 *             = 객체 관계 <=> 테이블 외래키 관계 => 어노테이션 
 *       5) 장단점 
 *          = SQL 의존도 감소 (객체 중심 개발)
 *          = 개발이 빠르다 (CRUD가 자동 처리)
 *          = 캐시 , 지연 로딩 => 성능 최적화 
 *          = 복잡한 객체 관계가 있는 경우 이해가 어렵다
 *          = 사용이 잘못되면 성능 저하 (N:1 => N:N)
 *       6) @Entity  : 테이블 매칭
 *       7) 생명주기
 *          JPA에 연결 => 메소드호출 => SQL제작 => DB연동 
 *       8) 사용법 / Native SQL / JPQL / JOIN / 외래키 
 *          => 객체 중심의 설계 
 *          => CRUD가 많은 경우 (ERP)
 *          => 대용량 => 백엔드 시스템 
 */
@Data
@Entity(name="board_1")
@DynamicUpdate
public class BoardEntity {
    @Id
	private int no;
    private String name;
    private String subject;
    private String content;
    @Column(insertable = true,updatable = false)
    private String pwd;
    @Column(insertable = true , updatable = false)
    private Date regdate;
    private int hit;
    
}