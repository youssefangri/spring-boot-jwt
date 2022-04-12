package com.erme.userauthjwt.service;

import java.util.List;

import com.erme.userauthjwt.bean.Role;
import com.erme.userauthjwt.bean.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
	User getUser(String username);
	List<User> getUsers();
}
