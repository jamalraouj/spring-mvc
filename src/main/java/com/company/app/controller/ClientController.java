package com.company.app.controller;



import com.company.app.classes.Cart;
import com.company.app.classes.Message;
import com.company.app.classes.PasserCommande;
import com.company.app.classes.ProductListForm;
import com.company.app.entity.Client;
import com.company.app.entity.Product;
import com.company.app.service.ClientService;
import com.company.app.service.ProductService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "visionarycrofting/client")
@SessionAttributes("cart")
public class ClientController {
    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart ();
    }
private final ClientService clientService;
    @Autowired
    private ProductService productService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping()
    @ResponseBody
    public List<Client> getClients(Model model)
    {
        System.out.println("mngjhgjhfjhv");
        return clientService.getClients();
    }

    @PostMapping("/addproducttocart/{client_id}/{productref}")
    public String addProductToCart(@ModelAttribute("cart") Cart cart ,Model model ,@PathVariable("client_id") Long clientId,@PathVariable("productref") String product_ref ){
        if ( cart != null) {
            cart.setProductReferences(product_ref);
            model.addAttribute("cart", cart);
        } else {
            Cart cart_ = new Cart ();
            cart.setProductReferences(product_ref);
            model.addAttribute("cart", cart);
        }
        List<Product> productList = new ArrayList<>();
        cart.getProductReferences().stream().forEach(ref->{
            productList.add(productService.getProductByReference(ref));
        });
        model.addAttribute ( "products",productList );
        productList.stream().forEach(p->{
            System.out.println(p.toString());
        });
        //return clientService.getOneById(clientId);
        return "command";

    }
    @GetMapping("/getproductofcart/{client_id}")
    public String getProductOfCart(Model model ,@PathVariable("client_id") Long clientId){
        Cart cart = new Cart ();
        List<Product> productList = new ArrayList<>();
        cart.getProductReferences().stream().forEach(ref->{
            productList.add(productService.getProductByReference(ref));
        });

        model.addAttribute ( "products",productList );

        return "command";

    }
    @GetMapping("/{client_id}")
    public Optional<Client> getOne(@PathVariable("client_id") Long clientId){
        return clientService.getOneById(clientId);
    }

    @PostMapping("/addClient")
    public Client registerNewClient(@RequestBody Client client)
    {
        return clientService.addClient(client);
    }

    @DeleteMapping(path = "deleteClient/{clientId}")
    public Message deleteClient(@PathVariable("clientId") Long clientId)
    {
        return clientService.deleteClient(clientId);
    }


    @PutMapping(path = "/updateClient")
    public Client updateClient(@RequestBody Client client)

    {
        return clientService.updateClient(client);
    }


//   @RequestMapping(path = "/passer_commande/{idClient}", method = RequestMethod.POST)
//    public String passerCommand(Model model,
//                                @PathVariable Long idClient,
//                                @ModelAttribute("productListForm") ProductListForm productListForm,
//                                @ModelAttribute("cart") Cart cart )
    @PostMapping("/passer_commande/{idClient}")
    public String passerCommande(Model model , @PathVariable Long idClient ,
                                 @ModelAttribute("productListForm") ProductListForm productListForm,
                                 @ModelAttribute("cart") Cart cart )
    {

//        System.out.println("||||||||||||||||||||||||||||||");
//        Collection<PasserCommande> listcommand = new ArrayList<>();
////        listcommand.add(passerCommande);
////        model.getAttribute("ref");
////        System.out.println("ref-> "+ref);
////        System.out.println("quantity ->"+ quantity);
////        System.out.println(passerCommande.toString());
//         model.addAttribute("client",clientService.passerCommande(id, listcommand));
//         model.addAttribute("commandList",clientService.getCommandByClient(id));
        if (idClient != null && idClient > 0) {
            String[] productList = productListForm.toString ().split ( "/" );
            Collection< PasserCommande> passerCommandes = new ArrayList <> (  );
            PasserCommande passerCommande = new PasserCommande (  );

            for ( int i = 0 ; i < productList.length ; i++ ) {
                String[] referenceQuantity = productList[i].split ( "," );
                passerCommande.setRef ( referenceQuantity[0] );
                passerCommande.setQuantity ( Integer.parseInt ( referenceQuantity[1]) );
                passerCommandes.add ( passerCommande );
            }
            clientService.passerCommande(idClient, passerCommandes);
        }
        cart.clear();
        model.addAttribute ( "products" , productService.getProducts () );
        return "home";
    }
//    @GetMapping("/passer_commande/{id}")
//    public String passerCommande(Model model , @PathVariable Long id)
//    {
//        model.addAttribute("commandList",clientService.getCommandByClient(id));
//        return "command";
//    }

}
