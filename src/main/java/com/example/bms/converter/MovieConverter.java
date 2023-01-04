package com.example.bms.converter;

import com.example.bms.Model.MovieEntity;
import com.example.bms.dto.EntryDto.MovieEntryDto;
import com.example.bms.dto.ResponseDto.MovieNameAndIdObject;
import com.example.bms.dto.ResponseDto.MovieResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static MovieEntity converDtotoEntity(MovieEntryDto movieEntryDto){
        return MovieEntity.builder().name(movieEntryDto.getName()).releaseDate(movieEntryDto.getReleaseDate()).build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity){
        return MovieResponseDto.builder().id(movieEntity.getId()).name(movieEntity.getName()).
                releaseDate(movieEntity.getReleaseDate()).build();
    }

    public static MovieNameAndIdObject convertEntitytoObject (MovieEntity movieEntity){
        return MovieNameAndIdObject.builder().id(movieEntity.getId()).name(movieEntity.getName()).build();
    }
}
