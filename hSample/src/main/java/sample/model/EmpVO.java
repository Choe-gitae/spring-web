package sample.model;

import lombok.Data;

@Data
public class EmpVO {
	private int		empno;
	private String	ename;
	private String	job;
	private String	mgr;
	private String	hiredate;
	private int		sal;
	private int		comm;
	private int		deptno;
}