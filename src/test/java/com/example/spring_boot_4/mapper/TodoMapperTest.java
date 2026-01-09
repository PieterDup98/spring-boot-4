package com.example.spring_boot_4.mapper;

import com.example.spring_boot_4.entity.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TodoMapperTest {

    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void roundTrip() {
        var entity = new TodoEntity(42L, "Write tests", ZonedDateTime.now(), true);

        var dto = todoMapper.toDto(entity);
        assertThat(dto.id()).isEqualTo(42L);
        assertThat(dto.description()).isEqualTo("Write tests");

        var back = todoMapper.toEntity(dto);
        assertThat(back.id()).isEqualTo(42L);
        assertThat(back.description()).isEqualTo("Write tests");
        assertThat(back.completed()).isFalse();
    }

}