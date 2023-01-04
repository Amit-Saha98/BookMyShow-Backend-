package com.example.bms.Service;

import com.example.bms.dto.EntryDto.TheatreEntryDto;
import com.example.bms.dto.ResponseDto.TheatreResponseDto;

public interface TheatreService {
    TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto);

    TheatreResponseDto getTheatre(int id);
}
