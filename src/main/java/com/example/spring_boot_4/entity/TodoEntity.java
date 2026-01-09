package com.example.spring_boot_4.entity;

import java.time.ZonedDateTime;

public record TodoEntity(Long id, String description, ZonedDateTime createdAt, boolean completed) {
}
