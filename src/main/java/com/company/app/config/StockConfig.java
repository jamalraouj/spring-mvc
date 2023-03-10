package com.company.app.config;


import com.company.app.entity.Stock;
import com.company.app.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StockConfig {


    @Bean
    CommandLineRunner commandLineRunner (StockRepository stockRepository ){
        return args -> {

//            public Stock(String name, String email, String password, String phone, String address, List<Object> productList, List<Object> providerList) {
//
                Stock ali = new Stock("ali", "ali@gamal.com", "1234", "2723838", "safi");
                Stock youssef = new Stock("youssef", "youssef@gamal.com", "1234", "2723838", "safi");
                Stock anas = new Stock("anas", "anas@gamal.com", "1234", "2723838", "safi");
                Stock abde = new Stock("abde", "abde@gamal.com", "1234", "2723838", "safi");
                stockRepository.saveAll(List.of(ali, youssef, anas, abde) );



        };
    }

}
