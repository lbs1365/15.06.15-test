package dao;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Emp;
import model.EmpDept;
@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	private SqlSession session;
	public List<Emp> list(Emp emp) {
		return session.selectList("listAll", emp);
	}
	public Emp detail(int empno) {
		return session.selectOne("detail",empno);
	}
	public int insert(Emp emp) {
		return session.insert("insert",emp);
	}
	public int delete(int empno) {
		return session.delete("delete",empno);
	}
	public int update(Emp emp) {
		return session.update("update",emp);
	}
	public List<EmpDept> listEmp(EmpDept empDept) {
		return session.selectList("listEmp", empDept);
	}
	public void insertEmp() {
		Emp emp = new Emp();
		for(int i = 3001; i <= 3120;i++){
			emp.setEmpno(i);
			emp.setEname("지현"+i);
			emp.setJob("영업");
			emp.setMgr(7369);
			emp.setHiredate("2015-10-11");
			emp.setSal(3000);
			emp.setComm(500);
			emp.setDeptno(20);
			session.insert("insert",emp);
		}
	}
	public int total() {
		return session.selectOne("total");
	}
}