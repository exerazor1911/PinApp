package com.pinapp.challenge.challenge.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoRequest {

    @NotNull(message = "El nombre del cliente es obligatorio")
    private String name;

    @NotNull(message = "El apellido del cliente es obligatorio")
    private String surname;

    @NotNull(message = "La edad del cliente es obligatoria")
    private Integer age;

    @NotNull(message = "La fecha de Nacimiento del cliente es obligatoria")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

}
