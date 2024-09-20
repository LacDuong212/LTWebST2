package LD01.services.impl;

import LD01.dao.IUserDao;
import LD01.dao.impl.UserDaoImpl;
import LD01.models.UserModel;
import LD01.services.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}
}
