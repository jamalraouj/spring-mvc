package com.company.app.config;


import com.company.app.entity.Provider;
import com.company.app.repository.ProviderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class providerConfig {
    @Bean
    CommandLineRunner commandLineRunner2 (ProviderRepository providerRepository){
        return args -> {
            Provider p1 = new Provider("jamal","raouj","jamal@gmail.com","1234","846236723","rabat");
            Provider p2 = new Provider("taybe","taybe","taybe@gmail.com","1234","87234723","rabat");
            Provider p3 = new Provider("maitite","mohammed","maitite@gmail.com","1234","28346784","rabat");
            providerRepository.saveAll ( List.of ( p1,p2,p3));
        };
    }
}
