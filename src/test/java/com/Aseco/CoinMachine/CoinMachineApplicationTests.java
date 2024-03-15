package com.Aseco.CoinMachine;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.Asseco.CoinMachine.CoinMachineApplication;
import com.Asseco.CoinMachine.Payload;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = {CoinMachineApplication.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class CoinMachineApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCountOccurrences() throws Exception {
        Payload payload = new Payload();
        payload.setRightPerson(Arrays.asList("P", "P", "R"));
        payload.setLeftPerson(Arrays.asList("P", "R", "R"));

        mockMvc.perform(MockMvcRequestBuilders.post("/coins")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(payload)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rightPerson").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.leftPerson").value(8));
    }
}
