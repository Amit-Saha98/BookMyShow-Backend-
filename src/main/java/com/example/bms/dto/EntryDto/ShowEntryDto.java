package com.example.bms.dto.EntryDto;

import com.example.bms.dto.ResponseDto.MovieResponseDto;
import com.example.bms.dto.ResponseDto.TheatreResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {

    @NotNull
    LocalDate showDate;

    @NotNull
    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    TheatreResponseDto theaterResponseDto;

}
