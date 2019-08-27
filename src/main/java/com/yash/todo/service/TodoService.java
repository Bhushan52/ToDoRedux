package com.yash.todo.service;

import java.util.List;
import java.util.Optional;

import com.yash.todo.model.ToDo;

public interface TodoService {

	boolean saveToDo(ToDo toDo);

	ToDo findTodoById(Integer todoId);

	List<ToDo> finAllTodo();

	boolean deleteById(Integer todoId);

	boolean updateTodo(ToDo toDo);

}
