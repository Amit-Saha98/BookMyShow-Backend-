package com.example.bms.Service;

import com.example.bms.dto.EntryDto.ShowEntryDto;
import com.example.bms.dto.ResponseDto.ShowResponseDto;

public interface ShowService {
    ShowResponseDto addShow(ShowEntryDto showEntryDto);

}
