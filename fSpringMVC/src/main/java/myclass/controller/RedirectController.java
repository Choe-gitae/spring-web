package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping(value = "insert.do")
	public String test() {
		return "redirect:select.do";
	}
	
	@RequestMapping(value = "select.do")
	public String test2(Model m) {
		m.addAttribute("info", "디비에서 넘어온 값");
		return "select";
	}

}
