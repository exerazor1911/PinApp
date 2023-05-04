package com.pinapp.challenge.challenge.dto.response;

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
public class ClientDtoList {

    private String name;

    private String surname;

    private Integer age;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate probableDateOfDeat;

}
