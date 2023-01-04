package com.example.bms.dto;

import com.example.bms.dto.ResponseDto.ShowResponseDto;
import com.example.bms.dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class TicketDto {
    int id;

    String alloted_seats;

    double amount;

    ShowResponseDto showDto;

    @NotNull
    UserResponseDto userDto; //Mandatory for me to fill this userDto Value
}
