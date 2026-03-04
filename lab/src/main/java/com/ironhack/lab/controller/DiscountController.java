package com.ironhack.lab.controller;

import com.ironhack.lab.service.EarlyBirdDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class DiscountController {
    private final EarlyBirdDiscountService earlyBirdDiscountService;

    @Autowired
    public DiscountController(Optional<EarlyBirdDiscountService> earlyBirdDiscountService){
        this.earlyBirdDiscountService = earlyBirdDiscountService.orElse(null);
    }

    @GetMapping("/api/discount")
    public String getDiscount(@RequestParam LocalDate bookingDate, @RequestParam LocalDate eventDate){
        if(earlyBirdDiscountService == null){
            return "Discount feature is disabled!";
        }
        return earlyBirdDiscountService.calculateDiscount(bookingDate, eventDate);
    }
}
