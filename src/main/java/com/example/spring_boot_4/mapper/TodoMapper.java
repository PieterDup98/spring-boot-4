package com.example.spring_boot_4.mapper;

import com.example.spring_boot_4.dto.TodoDto;
import com.example.spring_boot_4.entity.TodoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TodoMapper {


    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "createdAt", source = "createdAt")
    TodoDto toDto(TodoEntity entity);

    @InheritInverseConfiguration(name = "toDto")
    TodoEntity toEntity(TodoDto dto);

}
