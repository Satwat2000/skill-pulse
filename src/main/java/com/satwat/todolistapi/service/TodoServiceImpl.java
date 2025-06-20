package com.satwat.todolistapi.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.satwat.todolistapi.exception.TodoNotFoundException;
import com.satwat.todolistapi.models.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{

    private final List<Todo> todoData =  new ArrayList<>(List.of(
            new Todo("todo 1", 1L),
            new Todo("todo 2", 2L),
            new Todo("todo 3", 3L),
            new Todo("todo 4", 4L)
    ));


    @Override
    public List<Todo> getAllTodos (){
        return this.todoData;
    }

    @Override
    public List<Todo> getTodo (Long id){
        List<Todo> result = new ArrayList<>();
        for(Todo todo : todoData ){
            if(Objects.equals(todo.getId(), id)){
                result.add(todo);
            }
        }
        if(result.isEmpty()){
            throw new TodoNotFoundException(id);
        }
        return result;
    }
}
