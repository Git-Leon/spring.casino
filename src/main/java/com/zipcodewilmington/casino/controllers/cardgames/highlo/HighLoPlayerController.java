package com.zipcodewilmington.casino.controllers.cardgames.highlo;

import com.zipcodewilmington.casino.models.cardgames.highlo.HighLoPlayer;
import com.zipcodewilmington.casino.services.cardgames.highlo.HighLoPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "games/highlo/player")
public class HighLoPlayerController {
    private HighLoPlayerService highLoPlayerService;

    @Autowired
    public HighLoPlayerController(HighLoPlayerService highLoPlayerService) {
        this.highLoPlayerService = highLoPlayerService;
    }
    @PostMapping (name = "/")
    public ResponseEntity<HighLoPlayer> create(@RequestBody HighLoPlayer highLoPlayer) {
        return new ResponseEntity<>(highLoPlayerService.create(highLoPlayer), HttpStatus.CREATED);
    }
    @GetMapping(name = "/{id}")
    public ResponseEntity<HighLoPlayer>  read(@PathVariable Long accountId) {
        return new ResponseEntity<>(highLoPlayerService.read(accountId), HttpStatus.OK);
    }

    @PutMapping(name = "/{id}")
    public ResponseEntity<HighLoPlayer>  update(@PathVariable Long gameId, @RequestBody HighLoPlayer highLoPlayer) {
        return new ResponseEntity<>(highLoPlayerService.update(gameId, highLoPlayer), HttpStatus.OK);
    }

    @DeleteMapping(name = "/{id}")
    public ResponseEntity<HighLoPlayer> delete(@PathVariable Long gameId) {
        return new ResponseEntity<>(highLoPlayerService.delete(gameId), HttpStatus.OK);
    }
}
