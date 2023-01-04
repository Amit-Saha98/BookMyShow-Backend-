package com.example.bms.Service;

import com.example.bms.dto.EntryDto.UserEntryDto;
import com.example.bms.dto.ResponseDto.UserResponseDto;
import lombok.experimental.UtilityClass;


public interface UserService {
    void addUser(UserEntryDto userEntryDto);
    UserResponseDto getUser(int id);


}
