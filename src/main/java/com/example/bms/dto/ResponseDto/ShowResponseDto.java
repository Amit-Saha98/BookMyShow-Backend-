package com.example.bms.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponseDto {


    int id;

    LocalDate showDate;

    LocalTime showTime;

   // MovieResponseDto movieResponseDto;
    int movieId;
    String movieName;

   // TheatreResponseDto theaterDto;
    int theatreId;
    String theatreName;
    String address;
}
