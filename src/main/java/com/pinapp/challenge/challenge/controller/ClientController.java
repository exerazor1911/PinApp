package com.pinapp.challenge.challenge.controller;

import com.pinapp.challenge.challenge.dto.request.ClientDtoRequest;
import com.pinapp.challenge.challenge.dto.response.ClientResponseDto;
import com.pinapp.challenge.challenge.service.ClientService;
import com.pinapp.challenge.challenge.utility.GlobalConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(GlobalConstants.HOME)
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping(GlobalConstants.POST_CREATE_CLIENT)
    public ResponseEntity<?> createClient(@Valid @RequestBody ClientDtoRequest request) {
        ClientResponseDto savedClient = clientService.createClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping(GlobalConstants.GET_CLIENT_KPI)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getClientsKpi() {
        return ResponseEntity.ok().body(clientService.getClientsKpi());
    }

    @GetMapping(GlobalConstants.GET_LIST_CLIENTS)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getClientsList() {
        return ResponseEntity.ok().body(clientService.getClientsList());
    }

}
