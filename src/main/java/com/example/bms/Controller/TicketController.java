package com.example.bms.Controller;

import com.example.bms.Service.impl.TicketServiceImpl;
import com.example.bms.dto.EntryDto.BookTicketRequestDto;
import com.example.bms.dto.ResponseDto.TicketResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("get/{id}")
    public TicketResponseDto getTicketById(@PathVariable Integer id){

        return ticketService.getTicket(id);
    }

    @PostMapping("/add")
    public TicketResponseDto addTicket(@RequestBody() BookTicketRequestDto bookTicketRequestDto){


        log.info("In controller");
        return ticketService.bookTicket(bookTicketRequestDto);

    }
}
