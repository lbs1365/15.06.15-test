package dao;

import model.Emp;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	public void insert(User user) {
		String sql = "insert into userAccount values(" +
			":userId,:userName,:password,:postCode," +
			":address,:email,:job,:birthday)";
		SqlParameterSource sps = 
			new BeanPropertySqlParameterSource(user);
		npjt.update(sql, sps);
	}

	public void empin(Emp emp) {
		String sql = "insert into emp values(" +
				":empno,:ename,:job,:mgr,:hiredate," +
				":sal,:comm,:deptno)";
		SqlParameterSource sps = 
			new BeanPropertySqlParameterSource(emp);
		npjt.update(sql, sps);
	}
}

