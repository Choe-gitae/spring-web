package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 모델(데이터)를 뷰페이지로 전송
 * 1. ModelAndView
 * 		- addObject()
 * 
 * 2. Model : 호출함수의 인자에 선언 
 * 		- setAttribute()
 */

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@RequestMapping(value = "/modelandview.do")
	public ModelAndView test() {
		// 1. ModelAndView
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/void");
		mav.addObject("greeting", "asd");
		mav.addObject("test", "qwertyuo");
		return mav;
	}
	
	@RequestMapping(value = "/string.do")
	//*******************
	// Model : 뷰단으로 데이터 전송 객체
	//			====> 인자에 지정
	public String test2(Model m) {
		// 2. String return
		m.addAttribute("greeting", "asd");
		m.addAttribute("test", "qwertyuio");
		return "review/void";
	}
	
	@RequestMapping(value = "/void.do")
	public void test3(Model m) {
		// 3. void return
		m.addAttribute("greeting", "asd");
		m.addAttribute("test", "qwertyuio");
	}
	
}
