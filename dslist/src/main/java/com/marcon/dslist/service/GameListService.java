package com.marcon.dslist.service;

import com.marcon.dslist.dto.GameListDTO;
import com.marcon.dslist.entities.GameList;
import com.marcon.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public List<GameListDTO> findAll(){
        List<GameList> list = gameListRepository.findAll();
        return list.stream().map(x -> new GameListDTO(x)).toList();
    }
}
