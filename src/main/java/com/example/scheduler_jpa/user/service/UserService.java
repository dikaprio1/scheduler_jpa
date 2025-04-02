package com.example.scheduler_jpa.user.service;

import com.example.scheduler_jpa.user.dto.SignResponseDto;
import com.example.scheduler_jpa.user.dto.UserResponseDto;
import com.example.scheduler_jpa.user.dto.UserUpdateRequestDto;
import com.example.scheduler_jpa.user.entity.User;
import com.example.scheduler_jpa.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public SignResponseDto signUp(String userName, String email,String password){
        User user = new User(userName,email,password);
        User saveUser = userRepository.save(user);

        return new SignResponseDto(saveUser.getUserName(),saveUser.getEmail());
    }

    public List<UserResponseDto> findAll(){
        return userRepository.findAll().stream().map(UserResponseDto :: todto).toList();
    }

    public UserResponseDto findById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,id+"(id)값 존재하지않음");
        }
        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUserName(),findUser.getEmail());
    }
    @Transactional
    public void updateUser(Long id, UserUpdateRequestDto requestDto){
        User user = userRepository.findByIdOrElseThrow(id);

        if(requestDto.getUsername() != null){
            user.setUserName(requestDto.getUsername());
        }
        if(requestDto.getEmail() != null){
            user.setEmail(requestDto.getEmail());
        }
        if(requestDto.getPassword() != null){
            user.setPassword(requestDto.getPassword());
        }
    }
    public void deleteUser(Long id){
        User user = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(user);
    }
}
