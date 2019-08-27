package com.yash.todo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.todo.model.ToDo;

public interface TodoRepository extends JpaRepository<ToDo, Integer> {

}
