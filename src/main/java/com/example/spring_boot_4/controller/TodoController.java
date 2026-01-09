package com.example.spring_boot_4.controller;

import com.example.spring_boot_4.dto.TodoDto;
import com.example.spring_boot_4.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping(version = "1")
    public ResponseEntity<TodoDto> addTodo(@RequestParam String description) {
        LOGGER.info("Request received");
        final Optional<TodoDto> optionalTodo = todoService.addTodo(description);
        return ResponseEntity.of(optionalTodo);
    }

    @PostMapping(version = "2")
    public ResponseEntity<TodoDto> addTodo2(@RequestParam String description) {
        LOGGER.info("Request received");
        throw new HttpServerErrorException(HttpStatusCode.valueOf(500), "Failed to add todo");
    }
}
