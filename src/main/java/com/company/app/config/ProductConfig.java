package com.company.app.config;

import com.company.app.entity.Product;
import com.company.app.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner3 ( ProductRepository productRepository){
        return args -> {
            Product product1 = new Product ( "r1", "p1", 12.40, "d1", "cat1", 40, 15 );
            Product product2 = new Product ( "r2", "p2", 16.00, "d2", "cat2", 40, 10 );
            Product product3 = new Product ( "r3", "p3", 20.00, "d3", "cat3", 40, 2 );
            productRepository.saveAll ( List.of ( product1, product2, product3 ));
        };
    }
}
