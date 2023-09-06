package com.maxiron.todoapi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxiron.todoapi.dto.TodoRequest;
import com.maxiron.todoapi.entity.Todo;
import com.maxiron.todoapi.repository.TodoRepository;
import com.maxiron.todoapi.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(TodoRequest todoRequest) {
        // Create a new Todo object with the provided data
        Todo newTodo = Todo.builder()
            .title(todoRequest.getTitle())
            .body(todoRequest.getBody())
            .done(false)
            .build();
        
        return todoRepository.save(newTodo);
    }

    @Override
    public void delete(Long id) {
        // method to delete a todo by id
        todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> findAll() {
        // method to return all todos
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    @Override
    public Todo update(Long id, TodoRequest todoRequest) {
        // method to optionally update a todo
        // This will update only the fields present in the request
        // Handle the case where the todo is not found
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        
        // Process the fields that are present in the request
        if (todoRequest.getTitle() != null) {
            todo.setTitle(todoRequest.getTitle());
        }
        if (todoRequest.getBody() != null) {
            todo.setBody(todoRequest.getBody());
        }
        if (todoRequest.isDone() != todo.isDone()) {
            todo.setDone(todoRequest.isDone());
        }
        // Save the updated todo
        return todoRepository.save(todo);
    }

    public TodoRepository getTodoRepository() {
        return todoRepository;
    }

    public void setTodoRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
}