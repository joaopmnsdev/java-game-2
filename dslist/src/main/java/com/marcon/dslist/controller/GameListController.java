package com.marcon.dslist.controller;

import com.marcon.dslist.dto.GameListDTO;
import com.marcon.dslist.dto.GameMinDTO;
import com.marcon.dslist.dto.ReplacemantDTO;
import com.marcon.dslist.service.GameListService;
import com.marcon.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
       List<GameListDTO> result = gameListService.findAll();
       return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void updatePosition(@PathVariable Long listId, @RequestBody ReplacemantDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
