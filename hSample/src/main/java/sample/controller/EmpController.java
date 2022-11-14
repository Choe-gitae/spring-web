package sample.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.model.EmpVO;
import sample.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value = "empSelect.do")
	public String empSelect(Model model) {
		List<EmpVO> list = empService.empSelect();
		model.addAttribute("empList", list);
		return "empSelect";
	}
	
	@RequestMapping(value = "empDept.do")
	public String empDept(Model model) {
		List<HashMap> result = empService.empDept();
		model.addAttribute("result", result);
		for(HashMap map : result) {
			System.out.println(map);
		}
		return "empDept";
	}
	
}
