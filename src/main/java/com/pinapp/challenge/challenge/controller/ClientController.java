package com.pinapp.challenge.challenge.controller;

import com.pinapp.challenge.challenge.dto.request.ClientDtoRequest;
import com.pinapp.challenge.challenge.dto.response.ClientDto;
import com.pinapp.challenge.challenge.dto.response.ClientKpiDtoResponse;
import com.pinapp.challenge.challenge.dto.response.ClientResponseDto;
import com.pinapp.challenge.challenge.service.ClientService;
import com.pinapp.challenge.challenge.utility.GlobalConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Recurso de Clientes de la API",
        description = "Crear clientes y obtener informacion de los mismos."
)
@RestController
@RequestMapping(GlobalConstants.HOME)
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    @Operation(
            summary = "Crear un cliente"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Crea un cliente y retorna su informacion", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ClientDtoRequest.class))}),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
            }
    )
    @PostMapping(GlobalConstants.ENDPOINT_POST_CREATE_CLIENT)
    public ResponseEntity<?> createClient(@Valid @RequestBody ClientDtoRequest request) {
        ClientResponseDto savedClient = clientService.createClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }
    @Operation(
            summary = "Devuelve el promedio y la desviacion estandar de las edades de los Clientes"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Devuelve el promedio y la desviacion estandar de las edades de los Clientes", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ClientKpiDtoResponse.class))}),
            }
    )
    @GetMapping(GlobalConstants.ENDPOINT_GET_CLIENT_KPI)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getClientsKpi() {
        return ResponseEntity.ok().body(clientService.getClientsKpi());
    }
    @Operation(
            summary = "Devuelve la informacion de los clientes sumada a su probable fecha de muerte"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Devuelve la informacion de los clientes sumada a su probable fecha de muerte", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))}),
            }
    )
    @GetMapping(GlobalConstants.ENDPOINT_GET_LIST_CLIENTS)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getClientsList() {
        return ResponseEntity.ok().body(clientService.getClientsList());
    }

}
