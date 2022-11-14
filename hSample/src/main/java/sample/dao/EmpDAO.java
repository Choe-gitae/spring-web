package sample.dao;

import java.util.HashMap;
import java.util.List;

import sample.model.EmpVO;

public interface EmpDAO {

	public List<EmpVO> empSelect();
	public List<HashMap> empDept();

}