package com.example.scheduler_jpa.schedules.controller;

import com.example.scheduler_jpa.schedules.dto.CreateScheduleRequestDto;
import com.example.scheduler_jpa.schedules.dto.ScheduleResponseDto;
import com.example.scheduler_jpa.schedules.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getTitle(),requestDto.getContents(),requestDto.getId());
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.CREATED);
    }

}
