package com.example.spring_boot_4.dto;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.time.ZonedDateTime;

public record TodoDto(@Nullable Long id, @NonNull String description, @Nullable ZonedDateTime createdAt) {

}


