package com.maxiron.todoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maxiron.todoapi.entity.Todo;

// This todoRepo will be used to manipulate the Todo entity with a PK of type Long

public interface TodoRepository extends JpaRepository<Todo, Long> { 
}