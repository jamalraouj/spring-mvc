package com.company.app.controller;


import com.company.app.classes.Message;
import com.company.app.entity.Invoice;
import com.company.app.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/visionarycrofting/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/")
    @ResponseBody
    public List<Invoice> getInvoice(){return invoiceService.getInvoices();}

    @PostMapping("/insert/{idstock}/{idprovider}")
    @ResponseBody
    public Invoice addInvoice(@PathVariable("idstock") Long idstock ,@PathVariable("idprovider") Long idprovider , @RequestBody Invoice invoice)
    {
        return invoiceService.addInvoice(idstock ,idprovider  , invoice);
    }

    @DeleteMapping("/delete/{invoiceId}")
    @ResponseBody
    public Message deleteInvoice(@PathVariable("invoiceId") Long invoiceId )
    {
       return invoiceService.deleteInvoice(invoiceId);
    }

    @PutMapping("/update/{invoiceId}")
    @ResponseBody
    public Invoice updateProvider(@PathVariable("invoiceId") Long invoiceId,
                               @RequestBody Invoice invoice
    )
    {

       return invoiceService.updateInvoice(invoiceId , invoice);
    }
}
