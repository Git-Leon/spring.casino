package com.zipcodewilmington.casino.controllers.cardgames.highlo;

import com.zipcodewilmington.casino.models.cardgames.highlo.HighLoGame;
import com.zipcodewilmington.casino.services.cardgames.highlo.HighLoGameService;
import com.zipcodewilmington.springutils.AbstractController;
import com.zipcodewilmington.springutils.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "games/highlo")
public class HighLoGameController extends AbstractController<HighLoGame, Long> {
    @Autowired
    public HighLoGameController(HighLoGameService service) {
        super(service);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HighLoGame> read(@PathVariable Long id) {
        return super.read(id);
    }

    @PostMapping("/")
    public ResponseEntity<HighLoGame> create(@RequestBody HighLoGame highLoGame) {
        return super.create(highLoGame);
    }

    @PostMapping("/new")
    public ResponseEntity<HighLoGame> create() {

        return new ResponseEntity<>(service.create(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HighLoGame> update(@PathVariable Long id, @RequestBody HighLoGame highLoGame) {
        return new ResponseEntity<>(service.update(id, highLoGame), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HighLoGame> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}

