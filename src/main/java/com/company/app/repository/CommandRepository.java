package com.company.app.repository;


import com.company.app.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandRepository  extends JpaRepository<Command,Long> {

   @Query("select  com from Command  com where com.id=?1")
    Optional<Command> findCommandById(Long id);
//    @Query("select  com from Command  com where com.client=?1")
//   Optional<Command> findCommandByClientId(Long client);
}