package com.example.bms.Service.impl;

import com.example.bms.Enums.SeatType;
import com.example.bms.Enums.TheatreType;
import com.example.bms.Model.TheatreEntity;
import com.example.bms.Model.TheatreSeatEntity;
import com.example.bms.Repository.TheatreRepository;
import com.example.bms.Repository.TheatreSeatsRepository;
import com.example.bms.Service.TheatreService;
import com.example.bms.converter.TheatreConverter;
import com.example.bms.dto.EntryDto.TheatreEntryDto;
import com.example.bms.dto.ResponseDto.TheatreResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatsRepository theatreSeatsRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto) {
        TheatreEntity theatreEntity = TheatreConverter.convertDtoToEntity(theatreEntryDto);

        List<TheatreSeatEntity> seats = createTheatreSeats();

        theatreEntity.setSeats(seats);

        theatreEntity.setShows(null);

        for(TheatreSeatEntity theatreSeatEntity: seats){
            theatreSeatEntity.setTheatre(theatreEntity);
        }
        theatreEntity.setType(TheatreType.SINGLE);

        log.info("The theater entity is "+ theatreEntity);

        theatreEntity =theatreRepository.save(theatreEntity);
        theatreSeatsRepository.saveAll(seats);

        TheatreResponseDto theatreResponseDto = TheatreConverter.convertEntityToDto(theatreEntity);
        return theatreResponseDto;

    }

    List<TheatreSeatEntity>createTheatreSeats(){

        List<TheatreSeatEntity>seats = new ArrayList<>();
        seats.add(getTheatreSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheatreSeat("2A",200,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2B",200,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2C",200,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2D",200,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2E",200,SeatType.PREMIUM));

        return seats;
    }

    TheatreSeatEntity getTheatreSeat(String seatName, int rate, SeatType seatType){
        return TheatreSeatEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int id) {
        TheatreEntity theatreEntity = theatreRepository.findById(id).get();

        return TheatreConverter.convertEntityToDto(theatreEntity);
    }
}
