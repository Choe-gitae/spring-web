package sample.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.dao.EmpDAO;
import sample.model.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empDAO;
	
	@Override
	public List<EmpVO> empSelect() {
		return empDAO.empSelect();
	}
	
	@Override
	public List<HashMap> empDept() {
		return empDAO.empDept();
	}

}
