package com.example.Portfolio.repository;

import java.util.Optional;

import com.example.Portfolio.entity.User;

public interface IUserAccountDao {
	// Userを取得
	Optional<User> findUser(String userId);
}
