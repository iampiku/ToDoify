package com.todo.repository;

import com.todo.entity.Todo;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
