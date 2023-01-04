package com.example.bms.Service.impl;

import com.example.bms.Model.ShowEntity;
import com.example.bms.Model.ShowSeatsEntity;
import com.example.bms.Model.TicketEntity;
import com.example.bms.Model.UserEntity;
import com.example.bms.Repository.ShowRepository;
import com.example.bms.Repository.TicketRepository;
import com.example.bms.Repository.UserRepository;
import com.example.bms.Service.TicketService;
import com.example.bms.converter.ShowConverter;
import com.example.bms.converter.TicketConverter;
import com.example.bms.dto.BookTicketRequestDto;
import com.example.bms.dto.ResponseDto.TicketResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id){
        TicketEntity ticketEntity= ticketRepository.findById(id).get();

        return TicketConverter.convertEntityToDto(ticketEntity);
    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto){
        UserEntity userEntity =     userRepository.findById(bookTicketRequestDto.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        log.info("ticket half process");

        Set<String>requestSeats = bookTicketRequestDto.getRequestedSeats();

        List<ShowSeatsEntity> showSeatsEntityList= showEntity.getSeats();

        List<ShowSeatsEntity>bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat :showSeatsEntityList){
            if(seat.getBooked()==false) {
                log.info("flag 1");
                if (seat.getSeatType().equals(bookTicketRequestDto.getSeatType())) {
                    log.info("flag 2");
                    if (requestSeats.contains(seat.getSeatNumber())) {
                        log.info("flag 3");
                        bookedSeats.add(seat);
                    }
                }
            }
        }

        for(ShowSeatsEntity seat: bookedSeats) System.out.println(seat);
        if(bookedSeats.size()!=requestSeats.size()){
            //Al the seats were not avaiable
            throw new Error("All Seats not available");
        }

        TicketEntity ticketEntity = TicketEntity.builder().user(userEntity).show(showEntity).seats(bookedSeats).build();

        double amount = 0;

        for(ShowSeatsEntity seat : bookedSeats){
            seat.setBooked(true);
            seat.setBookedAt(new Date());
            seat.setTicket(ticketEntity);
            amount = amount +seat.getRate();
        }

        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);

        showEntity.getTickets().add(ticketEntity);

        userEntity.getTicketEntities().add(ticketEntity);

        ticketEntity = ticketRepository.save(ticketEntity);

        ShowConverter TicketConvertor;
        return TicketConverter.convertEntityToDto(ticketEntity);


    }

    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity :   bookedSeats){

            str = str + showSeatsEntity.getSeatNumber()+" ";
        }

        return str;

    }

}
