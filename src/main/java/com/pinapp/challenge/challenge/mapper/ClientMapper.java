package com.pinapp.challenge.challenge.mapper;

import com.pinapp.challenge.challenge.dto.request.ClientDtoRequest;
import com.pinapp.challenge.challenge.dto.response.ClientDto;
import com.pinapp.challenge.challenge.dto.response.ClientKpiDtoResponse;
import com.pinapp.challenge.challenge.dto.response.ClientResponseDto;
import com.pinapp.challenge.challenge.model.Client;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public Client clientDtoRequestToEntity(ClientDtoRequest request) {
        Client client = Client.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .age(request.getAge())
                .birthDate(request.getBirthDate())
                .build();

        return client;
    }

    public ClientKpiDtoResponse clientEntityList2KpiDtoResponse(Double avgAge, Double standardDeviation) {
        ClientKpiDtoResponse response = ClientKpiDtoResponse.builder()
                .ageAverage(avgAge)
                .standardDeviation(standardDeviation)
                .build();

        return response;
    }

    public ClientResponseDto clientEntityToResponseDto(Client entity) {
        ClientResponseDto response = ClientResponseDto.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .age(entity.getAge())
                .birthDate(entity.getBirthDate())
                .build();

        return response;
    }

    public List<ClientDto> clientEntityListToClientDtoList(List<Client> entities) {

        List<ClientDto> response = entities.stream()
                .map(client -> {
                    try {
                        ClientDto dto = ClientDto.builder()
                                .name(client.getName())
                                .surname(client.getSurname())
                                .age(client.getAge())
                                .birthDate(client.getBirthDate())
                                .probableDateOfDeath(MapperUtils.calculateProbableDeathDate(client.getBirthDate()))
                                .build();
                        return dto;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

        return response;
    }
}
