package com.satwat.todolistapi.service;
import com.satwat.todolistapi.models.Todo;
import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos ();
    List<Todo> getTodo (Long id);
}
