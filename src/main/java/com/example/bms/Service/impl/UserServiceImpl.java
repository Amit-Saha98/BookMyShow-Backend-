package com.example.bms.Service.impl;

import com.example.bms.Model.UserEntity;
import com.example.bms.Repository.UserRepository;
import com.example.bms.Service.UserService;
import com.example.bms.converter.UserConverter;
import com.example.bms.dto.EntryDto.UserEntryDto;
import com.example.bms.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserConverter.convertDtotoEntity(userEntryDto);
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {
        UserEntity user = new UserEntity();
        UserEntity userEntity = userRepository.findById(id).get();
        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(userEntity);
        return userResponseDto;
    }
}
