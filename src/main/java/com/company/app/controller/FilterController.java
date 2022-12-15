package com.company.app.controller;


import com.company.app.entity.Command;
import com.company.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/filter")
public class FilterController {

    @Autowired
    private final ClientService clientService;

    public FilterController ( ClientService clientService ) {
        this.clientService = clientService;
    }

    @GetMapping("/getCommandByClient/{id}")
    @ResponseBody
    public List<Command> getCommandByClient(@PathVariable Long id ){
        return clientService.getCommandByClient(id);
    }
}
