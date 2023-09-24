package com.blueharvest.bankingapi.controller;

import com.blueharvest.bankingapi.domain.Customer;
import com.blueharvest.bankingapi.model.CreateAccountRequest;
import com.blueharvest.bankingapi.wfw.IAccountWfw;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAccountWfw accountWfw;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup()
    {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCreateAccount() throws Exception {
        CreateAccountRequest request = new CreateAccountRequest(1, 100.0);
        when(accountWfw.createAccount(anyInt(), anyDouble())).thenReturn("Account 1 created successfully for customer 1");

        mockMvc.perform(post("/createAccount")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Account 1 created successfully for customer 1"));

        verify(accountWfw, times(1)).createAccount(1, 100.0);
    }

    @Test
    public void testGetUserInfo() throws Exception {
        Customer customerData  = new Customer(1, "name", "surname");
        com.blueharvest.bankingapi.model.Customer customerModel = new com.blueharvest.bankingapi.model.Customer(1, "name", "surname");

        when(accountWfw.getUserInfo(1)).thenReturn(customerModel);

        mockMvc.perform(get("/getUserInfo/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(customerModel)));

        verify(accountWfw, times(1)).getUserInfo(1);
    }
}