package com.app.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MessageControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        System.out.println("Antes!!!");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Después!!!");
    }

    @Test
    void findAll() throws Exception {
        var result = mockMvc.perform(get("/ecommerce/messages"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        var content = result.getResponse().getContentAsString();
        var messages = mapper.readValue(content, List.class);

        Assert.notNull(messages, "Lista de mensajes no nula");
        Assert.notEmpty(messages, "Lista de mensajes con elementos");
        Assert.isTrue(messages.size() == 5, "Tamaño de la lista es de 4");

    }

    @Test
    void createMessage() {
        System.out.println("Durante!!!");
    }

    @Test
    void deleteMessage() {
        System.out.println("Durante!!!");
    }

}