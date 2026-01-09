package com.example.spring_boot_4.repository;

import com.example.spring_boot_4.entity.TodoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoRepository {

    private List<TodoEntity> todos;

    public TodoEntity save(TodoEntity entityToSave) {
        if (todos == null) {
            todos = new ArrayList<>();
        }

        var newEntity = new TodoEntity((long) (todos.size() + 1), entityToSave.description(), entityToSave.createdAt(), entityToSave.completed());
        todos.add(newEntity);
        return newEntity;
    }

    public List<TodoEntity> findAll() {
        return todos;
    }
}
