package com.example.bms.Service;

import com.example.bms.dto.EntryDto.ShowEntryDto;
import com.example.bms.dto.ResponseDto.ShowResponseDto;

import java.util.List;

public interface ShowService {
    ShowResponseDto addShow(ShowEntryDto showEntryDto);
    ShowResponseDto getShow(int id);
    List<ShowResponseDto> getAllShow();

}
