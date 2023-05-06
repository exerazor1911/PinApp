package com.pinapp.challenge.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinapp.challenge.challenge.dto.request.ClientDtoRequest;
import com.pinapp.challenge.challenge.dto.response.ClientDto;
import com.pinapp.challenge.challenge.dto.response.ClientKpiDtoResponse;
import com.pinapp.challenge.challenge.dto.response.ClientResponseDto;
import com.pinapp.challenge.challenge.service.ClientService;
import com.pinapp.challenge.challenge.utility.GlobalConstants;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(ClientController.class)
class ClientControllerTest {




    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

 /*   @MockBean
    private JwtService jwtService; // TO MOCK CREDENTIALS*/

    ObjectMapper jsonMapper = new ObjectMapper();


    @Nested
    class createClientTest {
        @Test
        @DisplayName("Caso valido")
            //@WithMockUser(username = "mock.user@mockmail.mock", authorities = GlobalConstants.ROLE_ADMIN)
        void test1() throws Exception {
            ClientDtoRequest request = generateClientDtoRequest();
            ClientResponseDto expectedResponse = generateClientResponseDto();

            Mockito.when(clientService.createClient(Mockito.any())).thenReturn(expectedResponse);

            mockMvc.perform(MockMvcRequestBuilders.post(GlobalConstants.HOME + GlobalConstants.ENDPOINT_POST_CREATE_CLIENT)
                            .content(jsonMapper.writeValueAsString(request))
                            .contentType(MediaType.APPLICATION_JSON)
                    )

                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.content().json(jsonMapper.writeValueAsString(expectedResponse)))
                    .andDo(MockMvcResultHandlers.print());

            Mockito.verify(clientService).createClient(Mockito.any());
        }

        @Test
        @DisplayName("Caso no valido, campos faltantes")
            //@WithMockUser(username = "mock.user@mockmail.mock", authorities = GlobalConstants.ROLE_ADMIN)
        void test2() throws Exception {
            ClientDtoRequest request = ClientDtoRequest.builder().build();

            //Mockito.when(clientService.createClient(Mockito.any())).thenReturn(expectedResponse);

            mockMvc.perform(MockMvcRequestBuilders.post(GlobalConstants.HOME + GlobalConstants.ENDPOINT_POST_CREATE_CLIENT)
                            .content(jsonMapper.writeValueAsString(request))
                            .contentType(MediaType.APPLICATION_JSON)
                    )

                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(GlobalConstants.TEST_NAME_INVALID)))
                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(GlobalConstants.TEST_SURNAME_INVALID)))
                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(GlobalConstants.TEST_AGE_INVALID)))
                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(GlobalConstants.TEST_BIRTH_DATE_INVALID)))
                    .andDo(MockMvcResultHandlers.print());

        }
    }

    @Nested
    class getClientsKpiTest {
        @Test
        @DisplayName("Caso valido")
            //@WithMockUser(username = "mock.user@mockmail.mock", authorities = GlobalConstants.ROLE_ADMIN)
        void test1() throws Exception {

            ClientKpiDtoResponse expectedResponse = generateClientKpiDtoResponse();

            Mockito.when(clientService.getClientsKpi()).thenReturn(expectedResponse);

            mockMvc.perform(MockMvcRequestBuilders.get(GlobalConstants.HOME + GlobalConstants.ENDPOINT_GET_CLIENT_KPI))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.content().json(jsonMapper.writeValueAsString(expectedResponse)))
                    .andDo(MockMvcResultHandlers.print());

            Mockito.verify(clientService).getClientsKpi();
        }
    }

    @Nested
    class getClientsList {
        @Test
        @DisplayName("Caso valido")
            //@WithMockUser(username = "mock.user@mockmail.mock", authorities = GlobalConstants.ROLE_ADMIN)
        void test1() throws Exception {

            List<ClientDto> expectedResponse = generateClientDtoResponses();

            Mockito.when(clientService.getClientsList()).thenReturn(expectedResponse);

            mockMvc.perform(MockMvcRequestBuilders.get(GlobalConstants.HOME + GlobalConstants.ENDPOINT_GET_LIST_CLIENTS))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.content().json(jsonMapper.writeValueAsString(expectedResponse)))
                    .andDo(MockMvcResultHandlers.print());

            Mockito.verify(clientService).getClientsList();
        }
    }


    private static ClientResponseDto generateClientResponseDto() {
        ClientResponseDto response = ClientResponseDto.builder()
                .name("testname")
                .surname("testsurname")
                .age(18)
                .birthDate("15-02-1995")
                .build();

        return response;
    }

    private static ClientKpiDtoResponse generateClientKpiDtoResponse() {
        ClientKpiDtoResponse response = ClientKpiDtoResponse.builder()
                .ageAverage(GlobalConstants.TEST_AVG_AGE)
                .standardDeviation(GlobalConstants.TEST_STANDARD_DEV)
                .build();

        return response;
    }

    private static List<ClientDto> generateClientDtoResponses() {
        ClientDto response1 = ClientDto.builder()
                .name("testname")
                .surname("testsurname")
                .age(28)
                .birthDate("15-02-1995")
                .probableDateOfDeath("06-01-2071")
                .build();

        ClientDto response2 = ClientDto.builder()
                .name("testname2")
                .surname("testsurname2")
                .age(23)
                .birthDate("10-02-2000")
                .probableDateOfDeath("01-01-2076")
                .build();

        List<ClientDto> response = List.of(response1, response2);

        return response;
    }

    private static ClientDtoRequest generateClientDtoRequest() {
        ClientDtoRequest request = ClientDtoRequest.builder()
                .name("testname")
                .surname("testsurname")
                .age(18)
                .birthDate("15-02-1995")
                .build();

        return request;
    }
}