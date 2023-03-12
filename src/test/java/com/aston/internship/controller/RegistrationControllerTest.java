package com.aston.internship.controller;

import com.aston.internship.TestDetails;
import com.aston.internship.repository.DetailsRepository;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Field;

import static com.aston.internship.TestDetails.TestDetailsBuilder;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(RegistrationController.class)
@AutoConfigureMockMvc(addFilters = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations= "classpath:application-test.properties")
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DetailsRepository detailsRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    private TestDetails details;

    @BeforeAll
    void initialize(){ details = TestDetailsBuilder();}

    @Test
    public void registrationControllerIsCorrectlyWorking() throws Exception {

        MultiValueMap<String, String> allParams = new LinkedMultiValueMap<>();
        Field [] fields = details.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String key = field.getName();
            Object value = field.get(details);
            if (value != null) {
                allParams.add(key, value.toString());
            }
        }

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/register")
                .params(allParams)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andDo(print());

    }

}