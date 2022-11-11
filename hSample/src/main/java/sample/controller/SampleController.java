package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.service.SampleService;

@Controller
public class SampleController {

	@Autowired
	SampleService sampleService;
	
	@RequestMapping(value = "sample.do")
	public String getTime(Model model) {
		model.addAttribute("serverTime", sampleService.getTime());
		return "home";
	}
	
}
