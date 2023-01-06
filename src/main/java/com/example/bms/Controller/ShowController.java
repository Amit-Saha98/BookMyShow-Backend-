package com.example.bms.Controller;

import com.example.bms.Service.ShowService;
import com.example.bms.dto.EntryDto.ShowEntryDto;
import com.example.bms.dto.ResponseDto.ShowResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto){

        log.info("Here we are");

        return showService.addShow(showEntryDto);
    }

    @GetMapping("/get/{id}")
    public ShowResponseDto getShow(@PathVariable int id){
        return showService.getShow(id);
    }

    @GetMapping()
    public List<ShowResponseDto> getAllShow(){
        return showService.getAllShow();
    }
}
