package com.pinapp.challenge.challenge.service.impl;

import com.pinapp.challenge.challenge.dto.request.ClientDtoRequest;
import com.pinapp.challenge.challenge.dto.response.ClientDto;
import com.pinapp.challenge.challenge.dto.response.ClientKpiDtoResponse;
import com.pinapp.challenge.challenge.dto.response.ClientResponseDto;
import com.pinapp.challenge.challenge.mapper.ClientMapper;
import com.pinapp.challenge.challenge.model.Client;
import com.pinapp.challenge.challenge.repository.ClientRepository;
import com.pinapp.challenge.challenge.service.ClientService;
import com.pinapp.challenge.challenge.utility.LifeTableRow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientResponseDto createClient(ClientDtoRequest request) {
        Client client = clientMapper.clientDtoRequestToEntity(request);
        ClientResponseDto response = clientMapper.clientEntityToResponseDto(clientRepository.save(client));

        log.info(String.format("Client with the name: {} , surname: {} was created", response.getName(), response.getSurname()));

        return response;
    }

    public ClientKpiDtoResponse getClientsKpi() {
        List<Client> clients = clientRepository.findAll();
        Double avgAge = calculateAverageAge(clients);
        Double variance = getVariance(clients, avgAge);
        Double standardDeviation = calculateStdDeviation(variance);

        DecimalFormat df = new DecimalFormat("#.##");
        avgAge = Double.parseDouble(df.format(avgAge));
        standardDeviation = Double.parseDouble(df.format(standardDeviation));
        return clientMapper.clientEntityList2KpiDtoResponse(avgAge, standardDeviation);
    }

    @Override
    public List<ClientDto> getClientsList() {
        List<Client> clients = clientRepository.findAll();

        return clientMapper.clientEntityListToClientDtoList(clients);
    }

    private Double calculateStdDeviation(Double variance) {
        return Math.sqrt(variance);
    }

    private Double getVariance(List<Client> clients, Double avgAge) {
        double variance = clients.stream()
                .mapToDouble(client -> Math.pow(client.getAge() - avgAge, 2))
                .sum() / clients.size();
        return variance;
    }

    private Double calculateAverageAge (List<Client> clients) {
        Double averageAge = clients.stream()
                .mapToInt(Client::getAge)
                .average()
                .orElse(Double.NaN);

        return averageAge;
    }

}
