package com.maxiron.todoapi.service;

import java.util.List;

import com.maxiron.todoapi.dto.TodoRequest;
import com.maxiron.todoapi.entity.Todo;

// This service will be used to manipulate the Todo entity with a PK of type Long
public interface TodoService {

    // Define the methods that will be used to manipulate the Todo entity

    // This method will return a list of all the todos
    public List<Todo> findAll();

    // This method will update an existing todo
    public Todo update(Long id, TodoRequest todoRequest);

    // This method will delete an existing todo
    public void delete(Long id);

    // This method will return a todo by id
    public Todo findById(Long id);

    public Todo createTodo(TodoRequest todoRequest);
}
