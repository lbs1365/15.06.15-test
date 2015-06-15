package dao;

import model.Emp;
import model.User;

public interface UserDao {
	void insert(User user);
	void empin(Emp emp);
}
