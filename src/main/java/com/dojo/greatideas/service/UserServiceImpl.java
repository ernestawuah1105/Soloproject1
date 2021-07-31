package com.dojo.greatideas.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.greatideas.models.LoginUser;
import com.dojo.greatideas.models.User;
import com.dojo.greatideas.repositories.UserRepo;
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;
	public void registerUser(User user) {
		repo.save(user);
		
	}
	public String loginUser(@Valid LoginUser loginuser) {
		// TODO Auto-generated method stub
		User user = repo.findByEmail(loginuser.getEmail());
		if(loginuser.getPassword().equals(user.getPassword())) {
			return (user.getName());
		}
		
		return "";
	}

}
