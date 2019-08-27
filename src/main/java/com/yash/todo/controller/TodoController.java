package com.yash.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.todo.model.Status;
import com.yash.todo.model.ToDo;
import com.yash.todo.service.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping("/todos")
	public boolean todoPost(@RequestBody ToDo toDo) {
		toDo.setStatus(Status.ACTIVE);
		return todoService.saveToDo(toDo);
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/todos/{todoId}")
	@ResponseBody
	public ResponseEntity<ToDo>  todoGet(@PathVariable("todoId")Integer todoId){
		
		return new ResponseEntity<ToDo> (todoService.findTodoById(todoId), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/todos")
	@ResponseBody
	public ResponseEntity<List<ToDo>> todoGetAll() {
		return new ResponseEntity<List<ToDo>>(todoService.finAllTodo(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@DeleteMapping("/todos/{todoId}")
	public boolean todoDelete(@PathVariable("todoId")Integer todoId) {
		return todoService.deleteById(todoId);
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@PutMapping("/todos")
	public boolean todoUpdate(@RequestBody ToDo toDo) {
		return todoService.updateTodo(toDo);
	}

}
