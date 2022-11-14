package sample.service;

import java.util.HashMap;
import java.util.List;

import sample.model.EmpVO;

public interface EmpService {
	public List<EmpVO> empSelect();
	public List<HashMap> empDept();
}
