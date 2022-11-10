package myclass.controller;

/*
 * ������¡ ���
 * 1. ModelAndView�� ���� ( setViewName()�̿� )
 * 2. String ����	 : ����������
 * 3. void ���� : ��û���� ������ ��������
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myclass.model.MemberVO;

@Controller
@RequestMapping("re")
public class RequestMappingController {
	
	@RequestMapping(value = {"/a.do","/b.do"})
	public String test() {
		System.out.println("a.do�� b.do ��û");
		return "home";	// String ���� = �������� ����
	}
	
	@RequestMapping("c.do")
	public void test2(String id) {
		System.out.println("c.do ��û : "+id);
	}
	
	@RequestMapping(value = "/request.do", method = RequestMethod.POST)
	public void test3(MemberVO vo) {
		System.out.println("request.do ��û");
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
	}
	
}