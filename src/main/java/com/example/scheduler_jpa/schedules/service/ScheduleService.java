package com.example.scheduler_jpa.schedules.service;

import com.example.scheduler_jpa.schedules.dto.ScheduleResponseDto;
import com.example.scheduler_jpa.schedules.entity.Schedule;
import com.example.scheduler_jpa.schedules.repository.ScheduleRepository;
import com.example.scheduler_jpa.user.entity.User;
import com.example.scheduler_jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto save(String title, String contents, Long id){
        User findUser = userRepository.findByIdOrElseThrow(id);

        Schedule schedule = new Schedule(title,contents);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(),schedule.getContents());
    }
}
