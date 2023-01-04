package com.example.bms.Service;

import com.example.bms.dto.EntryDto.MovieEntryDto;
import com.example.bms.dto.ResponseDto.MovieNameAndIdObject;
import com.example.bms.dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);

    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);

}
