package com.example.scheduler_jpa.schedules.dto;

import com.example.scheduler_jpa.schedules.entity.Schedule;
import lombok.Getter;


// 스케줄 요청에 의한 반환 dto
@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final Long userId;

    public ScheduleResponseDto(Long id, String title, String contents,Long userId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userId =userId;
    }

    public static ScheduleResponseDto todto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents(),schedule.getUser().getId());
    }
}
