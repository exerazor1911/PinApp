package com.pinapp.challenge.challenge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pinapp.challenge.challenge.utility.GlobalConstants;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
public class ClientDtoRequest {

    @NotBlank(message = "El nombre del cliente es obligatorio")
    @JsonProperty("nombre")
    private String name;

    @NotBlank(message = "El apellido del cliente es obligatorio")
    @JsonProperty("apellido")
    private String surname;

    @NotNull(message = "La edad del cliente es obligatoria")
    @JsonProperty("edad")
    @Min(value = 18, message = "El cliente debe ser mayor de edad")
    @Max(value = 120, message = "El limite de edad es de 120")
    private Integer age;

    @NotBlank(message = "La fecha de Nacimiento del cliente es obligatoria")
    @Pattern(regexp = GlobalConstants.VALIDATION_DD_MM_YYYY)
    @JsonProperty("fechaDeNacimiento")
    private String birthDate;

}
