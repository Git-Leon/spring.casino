package com.zipcodewilmington.casino.controllers.cardgames.highlo;

import com.zipcodewilmington.casino.models.cardgames.highlo.HighLoPlayer;
import com.zipcodewilmington.casino.models.cardgames.utils.Card;
import com.zipcodewilmington.casino.services.cardgames.highlo.HighLoPlayerService;
import com.zipcodewilmington.springutils.AbstractController;
import com.zipcodewilmington.springutils.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "games/highlo/player")
public class HighLoPlayerController extends AbstractController<HighLoPlayer, Long, HighLoPlayerService> {
    public HighLoPlayerController(HighLoPlayerService service) {
        super(service);
    }

    @PutMapping("/addcard")
    public ResponseEntity<HighLoPlayer> addCard(
            @RequestBody HighLoPlayer player,
            @RequestBody Card card) {
        return new ResponseEntity<>(service.addCard(player, card), HttpStatus.OK);
    }
}
