package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.ReplyDAO;
import com.javassem.domain.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public Integer insertReply(ReplyVO vo) {
		return replyDAO.insertReply(vo);
	}

	@Override
	public List<ReplyVO> selectAllReply() {
		return replyDAO.selectAllReply();
	}

	@Override
	public int deleteReply(Integer rno) {
		return replyDAO.deleteReply(rno);
	}
	
	public int updateReply(ReplyVO vo) {
		return replyDAO.updateReply(vo);
	}
	
	

}
