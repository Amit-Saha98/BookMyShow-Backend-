package com.example.bms.converter;

import com.example.bms.Model.TheatreEntity;
import com.example.bms.dto.EntryDto.TheatreEntryDto;
import com.example.bms.dto.ResponseDto.TheatreResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {
    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theatreEntryDto){
        return TheatreEntity.builder().name(theatreEntryDto.getName()).
                address(theatreEntryDto.getAddress()).city(theatreEntryDto.getCity()).build();
    }

    public static TheatreResponseDto convertEntityToDto(TheatreEntity theatreEntity){
        return TheatreResponseDto.builder().id(theatreEntity.getId()).name(theatreEntity.getName())
                .address(theatreEntity.getAddress()).city(theatreEntity.getCity()).type(theatreEntity.getType()).build();
    }
}
