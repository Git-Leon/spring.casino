package com.zipcodewilmington.casino.controllers.cardgames.highlo;

import com.zipcodewilmington.casino.models.cardgames.highlo.HighLoPlayer;
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
public class HighLoPlayerController extends AbstractController<HighLoPlayer, Long> {
    public HighLoPlayerController(HighLoPlayerService service) {
        super(service);
    }
}
