package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;


// @Controller + @ResponsBody 같은 역할
@RestController
public class SampleController {
	
	@GetMapping(value = "getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		return "컨트롤러에서 보냄";
	}
	
	@GetMapping(value = "getObject")
	public SampleVO getObject() {
		SampleVO vo = new SampleVO("홍길동", 22, "하하하하하");
		return vo;
	}
	
	@GetMapping(value = "getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("홍길자", 20, "히히히히히"));
		list.add(new SampleVO("홍길국", 20, "흐흐흐흐흐"));
		list.add(new SampleVO("홍길밀", 20, "후후후후후"));
		return list;
	}
	
	@GetMapping(value = "sample/{cate}/{cno}")
	public String[] sample(@PathVariable String cate, @PathVariable String cno) {
		return new String[] {"카테고리:"+cate,"상품번호:"+cno};
	}
	
	@PostMapping(value = "sample/data")
	public SampleVO getDate(SampleVO vo) {
		return vo;
	}
	
}
