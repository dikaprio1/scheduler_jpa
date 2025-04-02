package com.example.scheduler_jpa.user.controller;

import com.example.scheduler_jpa.user.dto.SignResponseDto;
import com.example.scheduler_jpa.user.dto.SignUpRequestDto;
import com.example.scheduler_jpa.user.dto.UserResponseDto;
import com.example.scheduler_jpa.user.dto.UserUpdateRequestDto;
import com.example.scheduler_jpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){
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
    public ResponseEntity<Void> updateUser(@PathVariable Long id,@RequestBody UserUpdateRequestDto requestDto){
        userService.updateUser(id,requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
