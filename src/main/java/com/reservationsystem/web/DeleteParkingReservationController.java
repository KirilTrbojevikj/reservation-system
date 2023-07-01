package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteParkingReservationController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DeleteParkingReservationController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/DeleteParkingReservation")
    public String showDeleteParkingReservationForm() {
        return "DeleteParkingReservation";
    }

    @PostMapping("/DeleteParkingReservation")
    public String DeleteParkingReservation(
            @RequestParam("ParkingID") Integer ParkingID

    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CALL  DeleteParkingReservation( %d);", ParkingID));

        String sqlStatement = sb.toString();

        try {
            jdbcTemplate.execute(sqlStatement);
        } catch (Exception e) {
            // Handle exceptions
        }

        return "redirect:/home";
    }

}
