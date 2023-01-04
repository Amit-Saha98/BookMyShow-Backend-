package com.example.bms.converter;

import com.example.bms.Model.UserEntity;
import com.example.bms.dto.EntryDto.UserEntryDto;
import com.example.bms.dto.ResponseDto.UserResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static UserEntity convertDtotoEntity(UserEntryDto userEntryDto){
        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobNo()).build();
    }

    public static UserResponseDto convertEntityToDto (UserEntity userEntity){
        return UserResponseDto.builder().id(userEntity.getId()).name(userEntity.getName()).mobNo(userEntity.getMobile()).build();
    }
}
