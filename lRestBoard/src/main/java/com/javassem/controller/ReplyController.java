package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyService;

@RestController
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@PostMapping(value = "replies/new")
	public String insert(ReplyVO vo) {
		//System.out.println("입력요청 : "+vo);
		Integer result = replyService.insertReply(vo);
		if(result == 1) return "success";
		else return "error";
	}
	
	@GetMapping(value = "replies")
	public List<ReplyVO> selectAll() {
		return replyService.selectAllReply();
	}
	
	@DeleteMapping(value = "replies/{rno}")
	public String delete(@PathVariable Integer rno) {
		System.out.println(rno+"삭제");
		int result = replyService.deleteReply(rno);
		if(result ==1) return "success";
		else return "error";
	}
	
	@PostMapping(value = "repliesModify")
	public String modify(ReplyVO vo) {
		System.out.println(vo.getRno()+"수정");
		int result = replyService.updateReply(vo);
		if(result==1) return "success";
		else return "error";
	}
}
