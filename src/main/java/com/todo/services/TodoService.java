package com.todo.services;

import java.util.List;

import com.todo.dto.TodoDTO;
import com.todo.exception.TodoException;


public interface TodoService {
  public List<TodoDTO> getAllTodos() throws TodoException;

  public TodoDTO getTodoById(Integer todoId) throws TodoException;

  public Integer addTodo(TodoDTO todo) throws TodoException;

  public Integer updateTodo(TodoDTO todo) throws TodoException;

  public Integer deleteTodo(Integer todoId) throws TodoException;

  public List<TodoDTO> getTodoByStatus(String status) throws TodoException;
}
