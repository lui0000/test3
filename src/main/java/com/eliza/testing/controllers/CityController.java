package com.eliza.testing.controllers;

import com.eliza.testing.models.City;
import com.eliza.testing.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;


@Controller
@SessionScope
public class CityController {

    @Autowired
    private CityService cityService;

    private String currentPlayer = "Player 1";
    private int player1Time = 30;
    private int player2Time = 30;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("message", "Welcome to the Cities game! Player: " + currentPlayer);
        model.addAttribute("city", new City());
        model.addAttribute("player1Time", player1Time);
        model.addAttribute("player2Time", player2Time);
        return "city/index";
    }

    @PostMapping("/submitCity")
    public String submitCity(@ModelAttribute("city") City city, Model model) {
        String cityName = city.getCityName();
        boolean isValid = cityService.isCityExists(cityName);

        if (isValid) {
            // Передаем ход другому игроку
            currentPlayer = currentPlayer.equals("Player 1") ? "Player 2" : "Player 1";
            model.addAttribute("message", "The city is accepted. Move: " + currentPlayer);
        } else {
            model.addAttribute("message", "City not found. Try again.");
        }

        // Обновляем таймеры
        model.addAttribute("player1Time", player1Time);
        model.addAttribute("player2Time", player2Time);

        return "city/index";
    }
}



