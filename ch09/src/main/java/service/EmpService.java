package service;
import java.util.List;

import model.Dept;
import model.Emp;
import model.EmpDept;
public interface EmpService {
	List<Emp> list(Emp emp);
	Emp detail(int empno);
	List<Dept> select();
	List<EmpDept> listEmp(EmpDept empDept);
	int insert(Emp emp);
	int delete(int empno);
	int update(Emp emp);
	void insertEmp();
	int total();
}