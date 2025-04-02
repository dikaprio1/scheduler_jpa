package com.example.scheduler_jpa.schedules.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    private final String title;
    private final String contents;
    private final Long id;

    public CreateScheduleRequestDto(String title, String contents, Long id) {
        this.title = title;
        this.contents = contents;
        this.id = id;
    }
}
