package com.pinapp.challenge.challenge.controller;

import com.pinapp.challenge.challenge.dto.request.ClientDtoRequest;
import com.pinapp.challenge.challenge.service.ClientService;
import com.pinapp.challenge.challenge.utility.GlobalConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(GlobalConstants.HOME)
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody @Valid ClientDtoRequest request) {
        clientService.createClient(request);
    }

}
