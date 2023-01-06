package com.example.bms.converter;

import com.example.bms.Model.TicketEntity;
import com.example.bms.dto.ResponseDto.TicketResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {

    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity){
        return TicketResponseDto.builder().id((int)ticketEntity.getId()).amount(ticketEntity.getAmount()).
                alloted_seats(ticketEntity.getAllottedSeats()).build();
    }
}
