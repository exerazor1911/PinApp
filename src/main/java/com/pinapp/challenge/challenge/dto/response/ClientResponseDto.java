package com.pinapp.challenge.challenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("apellido")
    private String surname;

    @JsonProperty("edad")
    private Integer age;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("fechaDeNacimiento")
    private String birthDate;

}
