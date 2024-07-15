package com.neueda.payments;

import com.neueda.payments.model.Payment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DomainClassTests {

    @Test
    public void testEqualityOfPaymentsUsingIDOnly() {
        Payment p1 = new Payment();
        p1.setId(17L);
        Payment p2 = new Payment();
        p2.setId(17L);
        assertEquals(p1,p2);
    }

}
