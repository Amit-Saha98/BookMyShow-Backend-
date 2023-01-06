package com.example.bms.Service.impl;

import com.example.bms.Model.*;
import com.example.bms.Repository.MovieRepository;
import com.example.bms.Repository.ShowRepository;
import com.example.bms.Repository.ShowSeatsRepository;
import com.example.bms.Repository.TheatreRepository;
import com.example.bms.Service.ShowService;
import com.example.bms.converter.ShowConverter;
import com.example.bms.dto.EntryDto.ShowEntryDto;
import com.example.bms.dto.ResponseDto.ShowResponseDto;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {

        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        TheatreEntity theatreEntity = theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();

        showEntity.setMovie(movieEntity);
        showEntity.setTheatre(theatreEntity);

        showEntity = showRepository.save(showEntity);

        List<ShowSeatsEntity> showSeatsEntities = generateShowEntitySeats(theatreEntity.getSeats(),showEntity);
        showSeatsRepository.saveAll(showSeatsEntities);

        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity,showEntryDto);

        List<ShowEntity>showEntities=movieEntity.getShows();
        showEntities.add(showEntity);
        movieEntity.setShows(showEntities);
        movieRepository.save(movieEntity);
        return showResponseDto;

    }

    public List<ShowSeatsEntity>generateShowEntitySeats(List<TheatreSeatEntity>theatreSeatEntities,ShowEntity showEntity){
        List<ShowSeatsEntity>showSeatsEntities=new ArrayList<>();

        for(TheatreSeatEntity tse:theatreSeatEntities){
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber()).
                    seatType(tse.getSeatType()).rate(tse.getRate()).booked(false).build();
            showSeatsEntities.add(showSeatsEntity);
        }

        for (ShowSeatsEntity showSeatsEntity:showSeatsEntities){
            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setSeats(showSeatsEntities);
        return showSeatsEntities;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity showEntity= showRepository.findById(id).get();
        return ShowConverter.convertEntityToDto(showEntity);
    }

    @Override
    public List<ShowResponseDto> getAllShow() {
        List<ShowEntity>showEntities=showRepository.findAll();
        List<ShowResponseDto>showResponseDtos=new ArrayList<>();

        for(ShowEntity show:showEntities){
            showResponseDtos.add(ShowConverter.convertEntityToDto(show));
        }
        return showResponseDtos;
    }
}

