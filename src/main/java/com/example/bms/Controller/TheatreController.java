package com.example.bms.Controller;

import com.example.bms.Service.TheatreService;
import com.example.bms.dto.EntryDto.TheatreEntryDto;
import com.example.bms.dto.ResponseDto.TheatreResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public TheatreResponseDto addTheatre(@RequestBody TheatreEntryDto theatreEntryDto){
        return theatreService.addTheatre(theatreEntryDto);
    }

    @GetMapping("/get/{id}")
    public TheatreResponseDto getTheatre(@PathVariable int id ){
        return theatreService.getTheatre(id);
    }


    @GetMapping()
    public List<TheatreResponseDto> getAllTheatre(){
        return theatreService.getAllTheatres();
    }
}
