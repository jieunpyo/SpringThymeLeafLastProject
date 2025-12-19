package com.sist.web.controller;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class CommentRestController {
   private final CommentService cService;
   
   public Map commonseData(int cno,int type)
   {
	   Map map=new HashMap();
	   List<CommentVO> list=cService.commentListData(cno, type);
	   map.put("list", list);
	   map.put("cno", cno);
	   map.put("type", type);
	   return map;
	   // 이동 => cno / type 
   }
   @GetMapping("/comment/list_vue/")
   public ResponseEntity<Map> comment_list(@RequestParam("cno") int cno,
		   @RequestParam("type") int type)
   {
	   Map map=new HashMap();
	   try
	   {
		   map=commonseData(cno, type);
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
   }
   @PostMapping("/comment/insert_vue/")
   public ResponseEntity<Map> comment_insert(
		   @RequestBody CommentVO vo,HttpSession session)
   {
	   Map map=new HashMap();
	   try
	   {
		   String id=(String)session.getAttribute("id");
		   String name=(String)session.getAttribute("name");
		   vo.setId(id);
		   vo.setName(name);
		   cService.commentInsert(vo);
		   map=commonseData(vo.getCno(), vo.getType());
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
   }
   @GetMapping("/comment/delete_vue/")
   public ResponseEntity<Map> comment_delete(
		   @RequestParam("cno") int cno,
		   @RequestParam("type") int type,
		   @RequestParam("no") int no
		   )
   {
	   Map map=new HashMap();
	   try
	   {
		   cService.commentDelete(no);
		   map=commonseData(cno, type);
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
   }
   
   @GetMapping("/comment/update_vue/")
   public ResponseEntity<Map> comment_update(
		   @RequestParam("cno") int cno,
		   @RequestParam("type") int type,
		   @RequestParam("no") int no,
		   @RequestParam("msg") String msg
		   )
   {
	   Map map=new HashMap();
	   try
	   {
		   cService.commentUpdate(no,msg);
		   map=commonseData(cno, type);
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
   }
}
