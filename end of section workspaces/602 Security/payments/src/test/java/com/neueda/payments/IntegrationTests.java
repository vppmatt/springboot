package com.neueda.payments;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.neueda.payments.aspects.RepoLoggingAspect;
import com.neueda.payments.aspects.ServiceLoggingAspect;
import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import com.neueda.payments.service.BootstrapService;
import com.neueda.payments.service.UserBootstrapService;
import com.neueda.payments.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    @MockBean
    PaymentsRepository paymentsRepository;

    @MockBean
    UserService userService;

    @MockBean
    RepoLoggingAspect repoLoggingAspect;

    @MockBean
    ServiceLoggingAspect serviceLoggingAspect;

    @MockBean
    BootstrapService bootstrapService;

    @MockBean
    private UserBootstrapService userBootstrapService;

    @MockBean
    UserDetailsService userDetailsService;

    @Test
    public void testThatPostingANewTransactionGetsAddedToTheDatabase() throws Exception {

        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User user = new User("testuser", passwordEncoder.encode("abc"),roles);
        Mockito.when(userDetailsService.loadUserByUsername("testuser"))
                .thenReturn(user);

        Payment payment = new Payment();
        payment.setOrderId("223344");
        payment.setCountry("USA");
        payment.setAmount(17.33);

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(payment);

        String userPass = Base64.getEncoder().encodeToString("testuser:abc".getBytes());

        mockMvc.perform(post("/api/payment")
                        .header("Authorization", "Basic "+userPass)
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        ArgumentCaptor<Payment> capturedTransaction = ArgumentCaptor.forClass(Payment.class);

        Mockito.verify(paymentsRepository).save(capturedTransaction.capture());
        assertEquals("223344", capturedTransaction.getValue().getOrderId());

    }

}
