package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("start.do")
	public ModelAndView test() {
		System.out.println("request");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","�𸣰ڴ�");
		mv.addObject("data", "�߿䵥����");
		// WEB-INF/views + secret + .jsp
		mv.setViewName("secret");
		return mv;
	}
	
}
