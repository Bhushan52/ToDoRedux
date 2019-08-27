package com.yash.todo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.todo.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
