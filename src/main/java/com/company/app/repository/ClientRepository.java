package com.company.app.repository;


import com.company.app.entity.Client;
import com.company.app.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long>
{


Optional<Client> findClientByEmail(String email);

    @Query("SELECT c FROM Command c WHERE c.client.id = ?1")
    List <Command> findCommandByClient(Long id);

}


