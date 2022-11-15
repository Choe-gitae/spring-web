package com.javassem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;


@Controller
@RequestMapping(value = "/user")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "{url}.do")
	public String viewPage(@PathVariable String url) {
		System.out.println("경로 : "+url);
		return "/user/"+url;
	}
	
	@RequestMapping(value = "userInsert.do")
	public String userInsert(MemberVO vo, Model model) {
		int result = memberService.userInsert(vo);
		
		String message = null;
		if (result == 1) message = vo.getUserName()+"님 가입을 축하합니다.";
		model.addAttribute("message", message);
		
		return "/user/userJoin_ok";
	}
	
	@RequestMapping(value = "login.do")
	public String userLogin(MemberVO vo, HttpSession session) {
		MemberVO result = memberService.idCheck_Login(vo);
		if(result == null || result.getUserId() == null) {
			return "/user/userLogin";
		}else {
			session.setAttribute("login", result.getUserId());
			return "/user/login_ok";
		}
	}
	
	@RequestMapping(value = "idCheck.do", produces = "application/text;charset=utf-8")
	//*************************************
	// Ajax 통신 뷰페이지가 아니라 값을 전송해야 한다
	@ResponseBody
	public String checkId(MemberVO vo) {
		MemberVO result = memberService.idCheck_Login(vo);
		String message = "사용 가능한 아이디입니다";
		if(result != null) message = "중복된 아이디가 있습니다";
		return message;
	}
	
	@RequestMapping(value = "memberInfo.do")
	public String memberInfo() {
		return "/user/memberInfo";
	}
}
