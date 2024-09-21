package LD01.services;

import LD01.models.UserModel;

public interface IUserService {
	public UserModel findByUserName(String username);

	public UserModel login(String username, String password);
	
	public boolean register(UserModel user); 
}
