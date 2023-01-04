package com.example.bms.Model;

import com.example.bms.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.DatabindException;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Table(name = "show_seats")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ShowSeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "seat_number",nullable = false)
    private String seatNumber;

    @Column(name = "rate",nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type",nullable = false)
    private SeatType seatType;

    @Column(name = "is_booked")
    private Boolean booked = false;

    @Temporal(TemporalType.TIME)
    @Column(name = "booked_at")
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;

    @ManyToOne
    @JsonIgnore
    private TicketEntity ticket;
}
