package com.neueda.spring_jpa_demo.repositories;

import com.neueda.spring_jpa_demo.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
