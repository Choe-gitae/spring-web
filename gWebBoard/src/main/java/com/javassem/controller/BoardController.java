package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "getBoardList.do")
	public String getBoardList(String searchCondition, String searchKeyword, Model model) {
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<BoardVO> list = boardService.getBoardList(map);
		model.addAttribute("boardList", list);
		return "getBoardList";
	}
	
	@RequestMapping(value = "insertBoard.do")
	public String insertBoard() {
		return "insertBoard";
	}
	
	@RequestMapping(value = "saveBoard.do")
	public String saveBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value = "getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}
	
	@RequestMapping(value = "deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value = "updateBoard.do")
	public String updateBoard(BoardVO vo, Model model) {
		boardService.updateBoard(vo);
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}
	
	// 컨트롤러 테스트 함수
	@RequestMapping(value = "test.do")
	public void test() {
		System.out.println("test.do 요청 확인");
	}

}
