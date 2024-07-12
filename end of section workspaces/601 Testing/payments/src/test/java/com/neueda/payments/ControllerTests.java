package com.neueda.payments;

import com.neueda.payments.control.CountryController;
import com.neueda.payments.service.PaymentsService;
import com.neueda.payments.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ControllerTests {

    private CountryController countryController;

    public ControllerTests(CountryController countryController) {
        this.countryController = countryController;
    }

    @MockBean
    private PaymentsService paymentsService;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAllCountries() {
        Mockito.when(paymentsService.getCountries()).thenReturn(List.of("FRA","GBR", "USA"));
        List<String> result = countryController.getCountries();
        assertTrue(result.size() == 3);


    }
}
