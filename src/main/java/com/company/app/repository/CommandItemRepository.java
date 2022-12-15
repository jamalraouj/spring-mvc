package com.company.app.repository;


import com.company.app.entity.CommandItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandItemRepository extends JpaRepository<CommandItem, Long > {
}
