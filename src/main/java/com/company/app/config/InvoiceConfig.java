package com.company.app.config;


import com.company.app.entity.Invoice;
import com.company.app.repository.InvoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InvoiceConfig{


    @Bean
    CommandLineRunner commandLineRunnerInvoice9 (InvoiceRepository invoiceRepository){
        return args -> {

            Invoice c = new Invoice();
            c.setRef("refproduct83839");
            c.setRefproduct("prref389");
            c.setQuantity(034);
            Invoice d = new Invoice();
            d.setRef("refproduct5347");
            d.setRefproduct("prref526");
            d.setQuantity(934);
//            d.setStock(s2);
            Invoice k = new Invoice();
            k.setRef("refproduct0923");
            k.setRefproduct("prref024");
            k.setQuantity(532);
//            k.setStock(s3);
            invoiceRepository.saveAll(List.of(c,d,k));
        };
    }

}