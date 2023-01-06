package com.example.bms.dto.EntryDto;

import com.example.bms.Enums.SeatType;
import lombok.Data;

import java.util.Set;

@Data
public class BookTicketRequestDto {

        int id; // user id
        int showId;
        SeatType seatType;
        Set<String> requestedSeats;

}
