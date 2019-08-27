package com.yash.todo.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.todo.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFirstName(String firstname);

	Optional<User> findByUserName(String userName);
}
