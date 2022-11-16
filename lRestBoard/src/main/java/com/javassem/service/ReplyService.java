package com.javassem.service;

import java.util.List;

import com.javassem.domain.ReplyVO;

public interface ReplyService {
	public Integer insertReply(ReplyVO vo);
	public List<ReplyVO> selectAllReply();
	public int deleteReply(Integer rno);
	public int updateReply(ReplyVO vo);
}
