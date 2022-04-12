package com.erme.userauthjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erme.userauthjwt.bean.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
