package sample.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.model.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<EmpVO> empSelect() {
		return sqlSession.selectList("empDAO.empSelect");
	}
	
	@Override
	public List<HashMap> empDept() {
		return sqlSession.selectList("empDAO.empDept");
	}
	
}
