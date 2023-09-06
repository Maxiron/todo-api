package com.maxiron.todoapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxiron.todoapi.dto.TodoRequest;
import com.maxiron.todoapi.entity.Todo;
import com.maxiron.todoapi.service.TodoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/")
    // Get all todos
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    @PostMapping("/")
    public Todo createTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.createTodo(todoRequest);
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
    
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        return todoService.update(id, todoRequest);
    }
}
