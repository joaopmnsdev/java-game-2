package com.marcon.dslist.controller;

import com.marcon.dslist.dto.GameDTO;
import com.marcon.dslist.dto.GameMinDTO;
import com.marcon.dslist.entities.Game;
import com.marcon.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
       List<GameMinDTO> result = gameService.findAll();
       return result;
    }

    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id ){
       return gameService.findById(id);
    }


}
