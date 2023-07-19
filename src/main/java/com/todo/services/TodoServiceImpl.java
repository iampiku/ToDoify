package com.todo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dto.TodoDTO;
import com.todo.entity.Todo;
import com.todo.exception.TodoException;
import com.todo.repository.TodoRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<TodoDTO> getAllTodos() throws TodoException {
		List<TodoDTO> todoList = new ArrayList<>();
		Iterable<Todo> todos = todoRepository.findAll();
		todos.forEach(todo -> {
			TodoDTO returnTodo = new TodoDTO();

			returnTodo.setTodoID(todo.getTodoID());
			returnTodo.setTitle(todo.getTitle());
			returnTodo.setTask(todo.getTask());
			returnTodo.setStatus(todo.getStatus());
			returnTodo.setCreatedAt(todo.getCreationDate());

			todoList.add(returnTodo);
		});
		if (todoList.isEmpty())
			throw new TodoException("No todo items found");
		return todoList;
	}

	@Override
	public TodoDTO getTodoById(Integer todoId) throws TodoException {
		Optional<Todo> optionalTodo = todoRepository.findById(todoId);
		Todo todo = optionalTodo.orElseThrow(() -> new TodoException("No todo found with the given ID."));
		TodoDTO returnTodo = new TodoDTO();

		returnTodo.setTodoID(todo.getTodoID());
		returnTodo.setTitle(todo.getTitle());
		returnTodo.setTask(todo.getTask());
		returnTodo.setStatus(todo.getStatus());
		returnTodo.setCreatedAt(todo.getCreationDate());

		return returnTodo;
	}

	@Override
	public Integer addTodo(TodoDTO todo) throws TodoException {
		Todo todoEntity = new Todo();

		todoEntity.setTodoID(todo.getTodoID());
		todoEntity.setTitle(todo.getTitle());
		todoEntity.setTask(todo.getTask());
		todoEntity.setStatus(todo.getStatus());
		todoEntity.setCreationDate(todo.getCreatedAt());

		todoRepository.save(todoEntity);
		return todoEntity.getTodoID();
	}

	@Override
	public Integer updateTodo(TodoDTO todo) throws TodoException {
		Optional<Todo> fetchedTodo = todoRepository.findById(todo.getTodoID());
		Todo updateTodo = fetchedTodo.orElseThrow(() -> new TodoException("No todo found with the given ID."));

		updateTodo.setTitle(todo.getTitle());
		updateTodo.setTask(todo.getTask());
		updateTodo.setStatus(todo.getStatus());
		updateTodo.setCreationDate(todo.getCreatedAt());

		return updateTodo.getTodoID();
	}

	@Override
	public Integer deleteTodo(Integer todoId) throws TodoException {
		Optional<Todo> fetchedTodo = todoRepository.findById(todoId);
		Integer fetchedTodoID = fetchedTodo.orElseThrow(() -> new TodoException("Todo not found.")).getTodoID();
		todoRepository.deleteById(todoId);
		return fetchedTodoID;
	}

	@Override
	public List<TodoDTO> getTodoByStatus(String status) throws TodoException {
		Iterable<Todo> allTodos = todoRepository.findAll();
		List<TodoDTO> filterTodos = new ArrayList<>();
		boolean isTodoEmpty = !allTodos.iterator().hasNext();

		if (isTodoEmpty)
			throw new TodoException("No todo Items found");

		allTodos.forEach(todo -> {
			if (todo.getStatus().equalsIgnoreCase(status)) {
				TodoDTO todoDTO = new TodoDTO();
				todoDTO.setTodoID(todo.getTodoID());
				todoDTO.setTitle(todo.getTitle());
				todoDTO.setTask(todo.getTask());
				todoDTO.setStatus(todo.getStatus());
				todoDTO.setCreatedAt(todo.getCreationDate());

				filterTodos.add(todoDTO);
			}
		});
		return filterTodos;
	}
}
