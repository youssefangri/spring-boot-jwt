package com.erme.userauthjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erme.userauthjwt.bean.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
