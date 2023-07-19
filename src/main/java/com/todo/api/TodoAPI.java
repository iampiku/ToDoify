package com.todo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.TodoDTO;
import com.todo.exception.TodoException;
import com.todo.services.TodoService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/v1/api")
public class TodoAPI {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<TodoDTO>> getAllTodos() throws TodoException {
        List<TodoDTO> todoList = todoService.getAllTodos();
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable("id") Integer todoId) throws TodoException {
        TodoDTO todo = todoService.getTodoById(todoId);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @GetMapping("/todos/{status}")
    public ResponseEntity<List<TodoDTO>> getTodosByStatus(@PathVariable("status") String status) throws TodoException {
        List<TodoDTO> todoList = todoService.getTodoByStatus(status);
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<Integer> addTodo(@Valid @RequestBody TodoDTO todo) throws TodoException {
        Integer todoId = todoService.addTodo(todo);
        return new ResponseEntity<>(todoId, HttpStatus.CREATED);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<TodoDTO> deleteTodo(@PathVariable("id") Integer todoId) throws TodoException {
        TodoDTO todo = todoService.getTodoById(todoId);
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
}
