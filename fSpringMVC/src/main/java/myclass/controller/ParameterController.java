package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myclass.model.MemberVO;

@Controller
public class ParameterController {
	
							// value = "param*.do"
	@RequestMapping(value = {"param.do", "paramForm.do"})
	public String test(MemberVO vo) {
		return "parameter";
	}
	
}
