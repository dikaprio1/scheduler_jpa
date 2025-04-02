package com.example.scheduler_jpa.schedules.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ScheduleUpdateRequestDto {
    private final String title;
    private final String contents;

    public ScheduleUpdateRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
