package com.pinapp.challenge.challenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientKpiDtoResponse {

    @JsonProperty("promedioEdad")
    private Double ageAverage;

    @JsonProperty("desviacionEstandar")
    private Double standardDeviation;

}
