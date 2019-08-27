package com.yash.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.todo.model.ToDo;
import com.yash.todo.repos.TodoRepository;
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public boolean saveToDo(ToDo toDo) {
		todoRepository.save(toDo);
		return true;
	}

	@Override
	public ToDo findTodoById(Integer todoId) {
		Optional<ToDo> todo = todoRepository.findById(todoId);
		 if(todo.isPresent()) {
			 return todo.get();
		 }
		 return null;
	}

	@Override
	public List<ToDo> finAllTodo() {
		return todoRepository.findAll();
	}

	@Override
	public boolean deleteById(Integer todoId) {
		todoRepository.deleteById(todoId);
		return true;
	}

	@Override
	public boolean updateTodo(ToDo toDo) {
		Optional<ToDo> todo = todoRepository.findById(toDo.getId());
		ToDo todoExisting =todo.get();
		todoExisting.setName(toDo.getName());
		todoExisting.setStatus(toDo.getStatus());
		return true;
	}

}
