package com.company.app.controller;

import com.company.app.classes.Message;
import com.company.app.entity.Product;
import com.company.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/visionarycrofting/product")
public class ProductController {
    @Autowired
    ProductService productService;


    //public ProductController ( ProductService productService ) {
    //    this.productService = productService;
    //}

    @GetMapping()
    public String getProducts(Model model)
    {

        List<Product> p = productService.getProducts();
        model.addAttribute("products",p);

        System.out.println(model.getAttribute("products").toString());
        return "home";

    }
//    st:8080/visionarycrofting/product/filter/?filter=name&search=sss
    @GetMapping(path = "/filter/")
    public String getProducts(Model model , @RequestParam String filter , @RequestParam String search)
    {
        System.out.println(filter);
        System.out.println(search);
//        List<Product> p = productService.getProducts();
//        model.addAttribute("products",p);
//
//        System.out.println(model.getAttribute("products").toString());
        return "home";

    }

//    @RequestMapping(path = "/get/{id}", method=RequestMethod.GET)
    @GetMapping("/get/{id}")
    public String getProduct(Model model , @PathVariable Long id)
    {

        Product product = productService.findById(id);
        model.addAttribute("product",product);
        System.out.println(model.getAttribute("product").toString());
        return "shopdetail";

    }


    @PostMapping("/addProduct")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        boolean isValide = true;
        Message message = new Message (  );

        if (product.getProductReference () == null) {
            isValide = !isValide;
            message.setState ( "Error" );
            message.setMessage ( "Reference does not null value" );
            product.setMessage ( message );
        } else if (product.getQuantity () == null){
            isValide = !isValide;
            message.setState ( "Error" );
            message.setMessage ( "Quantity does not null value" );
            product.setMessage ( message );
        }else if (product.getQuantity () < 1){
            isValide = !isValide;
            message.setState ( "Error" );
            message.setMessage ( "Quantity does not negative or equal zero value" );
            product.setMessage ( message );
        } else if (product.getMinQuantity () < 0){
            isValide = !isValide;
            message.setState ( "Error" );
            message.setMessage ( "Quantity Min does not negative value" );
            product.setMessage ( message );
        } else if (product.getCategory () == null){
            isValide = !isValide;
            message.setState ( "Error" );
            message.setMessage ( "Category does not null value" );
            product.setMessage ( message );
        } else if (product.getName () == null) {
            isValide = !isValide;
            message.setState ( "Error" );
            message.setMessage ( "Name does not negative value" );
            product.setMessage ( message );
        }

        if (isValide) {
            message.setState ( "Success" );
            message.setMessage ( "your product has been successfully created" );
            product.setMessage ( message );
            return productService.addProduct(product);
        } else return product;
    }

    @PutMapping("/updateproduct")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Integer deleteProduct(@PathVariable Long id){ return productService.deleteProduct(id);}
}
