package com.example.Portfolio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Portfolio.entity.MyUserDetails;
import com.example.Portfolio.entity.User;
import com.example.Portfolio.repository.IUserAccountDao;

@Service
public class MyUserService implements UserDetailsService{
	
	private final IUserAccountDao dao;
	
	@Autowired
	public MyUserService(IUserAccountDao dao) {
		this.dao = dao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
		Optional<User> user = dao.findUser(userId);
		if(!user.isPresent()) {
			throw new UsernameNotFoundException(userId + "が存在しません");
		}
		System.out.println("loadUserByUsernameが呼ばれた");
		return new MyUserDetails(user.get());
	}
}