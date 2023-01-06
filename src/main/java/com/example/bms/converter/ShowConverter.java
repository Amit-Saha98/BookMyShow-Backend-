package com.example.bms.converter;

import com.example.bms.Model.ShowEntity;
import com.example.bms.dto.EntryDto.ShowEntryDto;
import com.example.bms.dto.ResponseDto.ShowResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {

    public static ShowEntity convertDtoToEntity(ShowEntryDto showDto){
        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime()).build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto){
        return ShowResponseDto.builder().id(showEntity.getId()).showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate()).movieId(showEntryDto.getMovieResponseDto().getId())
                .theatreId(showEntryDto.getTheaterResponseDto().getId()).theatreName(showEntryDto
                        .getTheaterResponseDto().getName()).movieName(showEntryDto.getMovieResponseDto()
                        .getName()).address(showEntryDto.getTheaterResponseDto().getAddress()).build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity){
        return ShowResponseDto.builder().id(showEntity.getId()).showTime(showEntity.getShowTime()).
                showDate(showEntity.getShowDate()).movieId(showEntity.getMovie().getId()).
                theatreId(showEntity.getTheatre().getId()).address(showEntity.getTheatre().getAddress()).
                movieName(showEntity.getMovie().getName()).theatreName(showEntity.getTheatre().getName()).build();
    }

}
