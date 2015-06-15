package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.Emp;
import model.User;
@Service 
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao ud;
	public void insert(User user) {
		ud.insert(user);
	}
	public void empin(Emp emp) {
		ud.empin(emp);
	}

}
