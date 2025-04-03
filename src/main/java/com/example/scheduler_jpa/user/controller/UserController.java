package com.example.scheduler_jpa.user.controller;

import com.example.scheduler_jpa.user.dto.SignResponseDto;
import com.example.scheduler_jpa.user.dto.SignUpRequestDto;
import com.example.scheduler_jpa.user.dto.UserResponseDto;
import com.example.scheduler_jpa.user.dto.UserUpdateRequestDto;
import com.example.scheduler_jpa.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignResponseDto> signUp(@Valid @RequestBody SignUpRequestDto requestDto){
        SignResponseDto signResponseDto = userService.signUp(requestDto.getUserName(),requestDto.getEmail(),requestDto.getPassword());
        return new ResponseEntity<>(signResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> userList = userService.findAll();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody UserUpdateRequestDto requestDto){
        userService.updateUser(id,requestDto);
        String responseMessage = "사용자 정보(ID: " + id + ")가 성공적으로 업데이트되었습니다.";
        log.info("응답 메시지: {}", responseMessage);
        return ResponseEntity.ok(responseMessage);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        String responseMessage = "사용자 정보(ID: " + id + ")가 성공적으로 삭제되었습니다.";
        log.info("응답 메시지: {}", responseMessage);
        return ResponseEntity.ok(responseMessage);
    }
}
