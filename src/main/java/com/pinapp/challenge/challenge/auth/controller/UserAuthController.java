package com.pinapp.challenge.challenge.auth.controller;

import com.pinapp.challenge.challenge.auth.dto.request.AuthenticationRequest;
import com.pinapp.challenge.challenge.auth.dto.request.UserDto;
import com.pinapp.challenge.challenge.auth.dto.response.AuthenticationResponse;
import com.pinapp.challenge.challenge.auth.service.SignInService;
import com.pinapp.challenge.challenge.auth.service.UserDetailsCustomService;
import com.pinapp.challenge.challenge.dto.request.ClientDtoRequest;
import com.pinapp.challenge.challenge.exception.RegisterException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(
        name = "Recurso De Creacion/Validacion de Usuarios de la API",
        description = "Crear y Validar usuarios de la aplicacion."
)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserDetailsCustomService userDetailsCustomService;

    private final SignInService signInService;
    @Operation(
            summary = "Crear un usuario"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Crea un usuario", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
            }
    )
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@Valid @RequestBody UserDto user) throws Exception {
        userDetailsCustomService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Operation(
            summary = "Autentica un usuario"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Autentica un usuario", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
            }
    )
    @PostMapping("/signin")
    public ResponseEntity<?> signIn (@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return signInService.signIn(authenticationRequest);
    }

}
