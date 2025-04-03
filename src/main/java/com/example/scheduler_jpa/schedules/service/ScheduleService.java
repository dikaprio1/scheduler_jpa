package com.example.scheduler_jpa.schedules.service;

import com.example.scheduler_jpa.schedules.dto.ScheduleResponseDto;
import com.example.scheduler_jpa.schedules.dto.ScheduleUpdateRequestDto;
import com.example.scheduler_jpa.schedules.entity.Schedule;
import com.example.scheduler_jpa.schedules.repository.ScheduleRepository;
import com.example.scheduler_jpa.user.entity.User;
import com.example.scheduler_jpa.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto save(String title, String contents, HttpSession session){
        String email = (String) session.getAttribute("userEmail");
        if (email == null) {
            throw new IllegalStateException("로그인이 필요합니다.");
        }

        User findUser = userRepository.findByEmailOrElseThrow(email);
        Schedule schedule = new Schedule(title,contents);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(),schedule.getContents(),schedule.getUser().getId());
    }

    public List<ScheduleResponseDto> findAll(){
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::todto).toList();
    }

    public ScheduleResponseDto findById(Long id){
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getContents(), findSchedule.getUser().getId());
    }
    @Transactional
    public void updateSchedule(Long id, ScheduleUpdateRequestDto requestDto){
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        if(requestDto.getTitle() != null){
            schedule.setTitle(requestDto.getTitle());
        }
        if(requestDto.getContents() != null){
            schedule.setContents(requestDto.getContents());
        }
    }
    public void delete(Long id){
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(schedule);
    }
}
