package com.example.bms.Service.impl;

import com.example.bms.Model.MovieEntity;
import com.example.bms.Repository.MovieRepository;
import com.example.bms.Service.MovieService;
import com.example.bms.converter.MovieConverter;
import com.example.bms.dto.EntryDto.MovieEntryDto;
import com.example.bms.dto.ResponseDto.MovieNameAndIdObject;
import com.example.bms.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto){

        MovieResponseDto movieResponseDto = null;

        if(movieRepository.existsByName(movieEntryDto.getName())){
            movieResponseDto.setName("This Movie Already Exist");
            return movieResponseDto;
        }

        log.info("In the function add movie "+ movieEntryDto);

        MovieEntity movieEntity = MovieConverter.converDtotoEntity(movieEntryDto);
        movieEntity = movieRepository.save(movieEntity);
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id){
        MovieEntity movieEntity = movieRepository.findById(id).get();
        return MovieConverter.convertEntityToDto(movieEntity);
    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id) {
        MovieEntity movieEntity = movieRepository.findById(id).get();
        return MovieConverter.convertEntitytoObject(movieEntity);
    }
}
