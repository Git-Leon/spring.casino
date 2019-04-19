package com.zipcodewilmington.casino.controllers;

import com.zipcodewilmington.casino.models.Account;
import com.zipcodewilmington.casino.services.AccountService;
import com.zipcodewilmington.springutils.AbstractController;
import com.zipcodewilmington.springutils.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This class exposes endpoints to manipulate account entities
 */
@Controller
@RequestMapping(value = "/accounts")
public class AccountController extends AbstractController<Account, Long> {
    @Autowired
    public AccountController(AccountService service) {
        super(service);
    }
}
