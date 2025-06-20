package com.satwat.todolistapi.controller;


import com.satwat.todolistapi.models.Todo;
import com.satwat.todolistapi.service.TodoService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    // Get all the todos
    // GET /
    @GetMapping()
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // Get a todo
    // GET /{id}
    @GetMapping("/{id}")
    public List<Todo> getTodo(@PathVariable Long id){
        return todoService.getTodo(id);
    }

    // Add a todo
    // POST /
    //    @GetMapping()
    //    public List<Todo> insertTodo(Todo todo){
    //        return todoService.addTodo(todo);
    //    }

    // Edit a todo
    // PATCH /{id}

    // Delete a todo
    // DELETE /{id}

}
