package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper // 매핑 => 어노테이션 / XML 연동 
@Repository // 메모리 할당 = Spring이 관리가 가능하게 
/*
 *   Spring => 클래스 관리 (Container) 
 *             | 의존성이 낮은 프로그램 (수정시에 다른 클래스에 영향이 없는 프로그램)
 *      *** 어떤 클래스 관리
 *          VO / Entity
 *           |     |
 *           -------
 *             | 데이터형 (사용자 정의) 
 *          interface 
 *          -------------------------- 제외 나머지는 관리 
 *      *** 어떤 역할을 수행하는지 확인 
 *          분리 
 *           | @Component 
 *           | @Repository
 *           | @Service 
 *           | @Controller
 *           | @RestController
 *           | @ControllerAdvice => 스프링에서 관리하는 클래스 
 *                                  | 객체 생성 ~ 객체 소멸 
 *           => 스프링안에서 객체(싱글턴)를 찾기 
 *              => @Autowired => getBean()
 *              => 생성자를 통해 객체 찾기  
 *                 @RequiredArgsConstructor (가장 많이 사용)
 *                   => 생성자 위에 @Autowired가 포함 
 *                   => 스프링(X) , lombok에서 지원
 *           => 동작                        위임
 *              요청 === DispatcherServlet ===== HandlerMapping
 *                                                  |
 *                                                사용자 정의 
 *                                                @Controller
 *                                                @RestController
 *                                                  | URI주소 찾는다 
 *                                                  | @GetMapping
 *                                                  | @PostMapping
 *                                                해당 메소드 호출 
 *                                                  | Model
 *                                                ViewResolver 
 *                                                  | JSP/HTML을 찾기 
 *                                                 전송 
 *                                                 --- 받는 데이터로 출력
 *              => 자동 셋팅 : prefix / suffix 
 *              => Framework에 있는 XML (셋팅 파일을 자동 처리) 
 *                 ---------- 간결하게 만든 프로그램 
 *              => 어노테이션이 존재 => @RequestMapping 사라진다
 *                                 ----------------            
 */
// #{name} 'honggildong' ${name} honggildong
// 일반 데이터는 #{} , 컬럼/테이블 => ${}
/*
 * 
 *     USER (브라우저)
 *         |
 *      Controller   <====>  Mapper   
 *      
 *     USER (브라우저)
 *         |
 *      Controller  <=====> Service <=====> Mapper
 *      ------------------------------------------
 *      => 3.xxx ==> 자바소스 
 *         java == class   class == java 
 *               |                |
 *             javac            javap
 */
public interface SeoulMapper {
   @Select("SELECT no,title,poster,msg,address,rownum "
		  +"FROM (SELECT no,title,poster,msg,address "
		  +"FROM ${table_name} ORDER BY no DESC) "
		  +"WHERE rownum<=3")
   public List<SeoulVO> seoulMainData(Map map);
}