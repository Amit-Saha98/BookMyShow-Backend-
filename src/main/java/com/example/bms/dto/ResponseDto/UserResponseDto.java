package com.example.bms.dto.ResponseDto;

import com.example.bms.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    int id;

    String name;

    String mobNo;

    //Optional
    List<TicketDto> tickets;
}
