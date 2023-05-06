package com.pinapp.challenge.challenge.service;

import com.pinapp.challenge.challenge.dto.request.ClientDtoRequest;
import com.pinapp.challenge.challenge.dto.response.ClientDto;
import com.pinapp.challenge.challenge.dto.response.ClientKpiDtoResponse;
import com.pinapp.challenge.challenge.dto.response.ClientResponseDto;

import java.util.List;

public interface ClientService {
    public ClientResponseDto createClient(ClientDtoRequest request);

    public ClientKpiDtoResponse getClientsKpi();

    public List<ClientDto> getClientsList();
}
