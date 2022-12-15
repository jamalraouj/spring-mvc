package com.company.app.controller;


import com.company.app.classes.Message;
import com.company.app.entity.Product;
import com.company.app.entity.Provider;
import com.company.app.service.ProviderService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "visionarycrofting/Provider")
public class providerController {

    private final ProviderService providerService;

    public providerController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/Providers")
    public String getProviders(Model model)
    {
       model.addAttribute("data", providerService.getProviders());
       return "index";
    }

    @PostMapping("/addProvider")
    public void addProvider(@RequestBody Provider provider)
    {
        providerService.addProvider(provider);
    }

    @DeleteMapping("/deleteProvider/{providerId}")
    public Message deleteProvider(@PathVariable("providerId") Long providerId )
    {
        return providerService.deleteProvider(providerId);
    }

    @PutMapping("/updateProvider")
    @ResponseBody
    public Provider updateProvider(@RequestBody Provider provider)
    {
        providerService.updateProvider(provider);
        return provider;
    }

    @PutMapping ("/validateInvoice/{id}")
    public Optional <Product> validateInvoice(@PathVariable("id") Long id)
    {
        return providerService.validateInvoice(id);
    }
}
