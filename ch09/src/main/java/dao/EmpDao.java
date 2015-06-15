package dao;
import java.util.List;

import model.Emp;
import model.EmpDept;
public interface EmpDao {
	List<Emp> list(Emp emp);
	List<EmpDept> listEmp(EmpDept empDept);
	Emp detail(int empno);
	int insert(Emp emp);
	int delete(int empno);
	int update(Emp emp);
	void insertEmp();
	int total();
}