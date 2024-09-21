package LD01.dao;

import java.util.List;

import LD01.models.UserModel;

public interface IUserDao {
	
	List<UserModel> findALL();
	
	UserModel findById(int id);
	
	UserModel findByUsername(String username);
	
	boolean insert(UserModel user);
}
