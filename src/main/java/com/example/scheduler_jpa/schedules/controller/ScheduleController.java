package com.example.scheduler_jpa.schedules.controller;

import com.example.scheduler_jpa.schedules.dto.CreateScheduleRequestDto;
import com.example.scheduler_jpa.schedules.dto.ScheduleResponseDto;
import com.example.scheduler_jpa.schedules.dto.ScheduleUpdateRequestDto;
import com.example.scheduler_jpa.schedules.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 스케줄 등록
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto, HttpSession session){
        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getTitle(),requestDto.getContents(),session);
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.CREATED);
    }

    // 등록되어있는 스케줄 목록 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDtoList,HttpStatus.OK);
    }

    // 등록되어있는 스케줄 1개 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
    }

    // 등록되어있는 스케줄 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable Long id,@RequestBody ScheduleUpdateRequestDto requestDto){
        scheduleService.updateSchedule(id,requestDto);
        String responseMessage = "스케줄 정보(ID: " + id + ")가 성공적으로 업데이트되었습니다.";
        log.info("응답 메시지: {}", responseMessage);
        return ResponseEntity.ok(responseMessage);
    }

    // 등록되어있는 스케줄 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        scheduleService.delete(id);
        String responseMessage = "스케줄 정보(ID: " + id + ")가 성공적으로 삭제되었습니다.";
        log.info("응답 메시지: {}", responseMessage);
        return ResponseEntity.ok(responseMessage);
    }

}
