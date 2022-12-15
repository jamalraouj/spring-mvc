package com.company.app.repository;

import com.company.app.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider,Long>
{

    Optional<Provider> findProviderByEmail(String email);


}
