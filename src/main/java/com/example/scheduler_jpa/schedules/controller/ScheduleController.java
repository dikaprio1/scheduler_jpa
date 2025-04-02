package com.example.scheduler_jpa.schedules.controller;

import com.example.scheduler_jpa.schedules.dto.CreateScheduleRequestDto;
import com.example.scheduler_jpa.schedules.dto.ScheduleResponseDto;
import com.example.scheduler_jpa.schedules.dto.ScheduleUpdateRequestDto;
import com.example.scheduler_jpa.schedules.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDtoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSchedule(@PathVariable Long id,@RequestBody ScheduleUpdateRequestDto requestDto){
        scheduleService.updateSchedule(id,requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
