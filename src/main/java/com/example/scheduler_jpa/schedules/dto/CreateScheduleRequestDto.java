package com.example.scheduler_jpa.schedules.dto;

import lombok.Getter;

//스케줄 등록 dto
@Getter
public class CreateScheduleRequestDto {
    private final String title;
    private final String contents;

    public CreateScheduleRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
