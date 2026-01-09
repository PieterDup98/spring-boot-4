package com.example.spring_boot_4.service;

import com.example.spring_boot_4.dto.TodoDto;
import com.example.spring_boot_4.mapper.TodoMapper;
import com.example.spring_boot_4.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private TodoMapper mapper;
    private TodoRepository repository;

    public TodoService(TodoMapper mapper, TodoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Optional<TodoDto> addTodo(String description) {
        var newTodo = new TodoDto(null, description, ZonedDateTime.now());
        var savedEntity = repository.save(mapper.toEntity(newTodo));

        return Optional.of(mapper.toDto(savedEntity));
    }

    public List<TodoDto> getAllTodos() {
        var todoEntities = repository.findAll();

        return todoEntities.stream().map(mapper::toDto).toList();
    }
}
