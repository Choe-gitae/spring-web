package sample.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDaoImpl implements SampleDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public String getTime() {
		System.out.println("Mybatis - getTime() 호출");
		return mybatis.selectOne("mm.getTime");
	}

}
