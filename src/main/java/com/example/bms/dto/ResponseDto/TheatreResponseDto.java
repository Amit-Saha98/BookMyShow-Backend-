package com.example.bms.dto.ResponseDto;

import com.example.bms.Enums.TheatreType;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponseDto {
    @NotNull
    int id;

    String name;
    String address;
    String city;
    TheatreType type;

}
