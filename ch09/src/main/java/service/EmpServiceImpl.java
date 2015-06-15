package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DeptDao;
import dao.EmpDao;
import model.Dept;
import model.Emp;
import model.EmpDept;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;
	@Autowired
	private DeptDao dd;
	public List<Emp> list(Emp emp) {
		return ed.list(emp);
	}
	public Emp detail(int empno) {
		return ed.detail(empno);
	}
	public List<Dept> select() {
		return dd.select();
	}
	public int insert(Emp emp) {
		return ed.insert(emp);
	}
	public int delete(int empno) {
		return ed.delete(empno);
	}
	public int update(Emp emp) {
		return ed.update(emp);
	}
	public List<EmpDept> listEmp(EmpDept empDept) {
		return ed.listEmp(empDept);
	}
	public void insertEmp() {
		ed.insertEmp();
	}
	public int total() {
		return ed.total();
	}
}