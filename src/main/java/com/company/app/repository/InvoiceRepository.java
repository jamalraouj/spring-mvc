package com.company.app.repository;

import com.company.app.entity.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
