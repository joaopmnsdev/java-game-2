package com.marcon.dslist.service;

import com.marcon.dslist.dto.GameDTO;
import com.marcon.dslist.dto.GameMinDTO;
import com.marcon.dslist.entities.Game;
import com.marcon.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
      List<Game> result = gameRepository.findAll();
     return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result =  gameRepository.findById(id).get();
        return new GameDTO(result);
    }

}
