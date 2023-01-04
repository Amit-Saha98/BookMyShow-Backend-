package com.example.bms.Service;

import com.example.bms.dto.BookTicketRequestDto;
import com.example.bms.dto.ResponseDto.TicketResponseDto;

public interface TicketService {

    TicketResponseDto getTicket(int id);

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);
}
