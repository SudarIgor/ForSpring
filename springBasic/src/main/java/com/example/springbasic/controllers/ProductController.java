package com.example.springbasic.controllers;

import com.example.springbasic.Services.ProductService;
import com.example.springbasic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/json_all")
    @ResponseBody
    public List<Product> productAllJson(){
        return productService.findAll();
    }

    @GetMapping("/json/{id}")
    @ResponseBody
    public Product productAllJson(@PathVariable long id){
        return productService.findById(id);
    }

//    @RequestBody Product product - означает, что прилетевший в теле запроса json необходимо преобразовать к Product
    @PostMapping("/json")
    @ResponseBody
    public void saveProductJson(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping("/show_all")
    public String productAll(Model model){
        model.addAttribute("products", productService.findAll());
        return "products/products";
    }

    @GetMapping("/{id}")
    public String productById(Model model, @PathVariable long id){
        model.addAttribute("product", productService.findById(id));
        return "products/product";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("product", new Product());
        return "products/create_product";
    }

//    @PostMapping("/create")
//    public String createProduct(@RequestParam String title, @RequestParam double cost){
//        Product product = new Product(0, title, cost);
//        productService.save(product);
//        return "redirect:/products/";
//    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/products/show_all";
    }

//    homework 4
    @GetMapping ("{id}/change_cost")
    public String changeCost(@PathVariable long id, @RequestParam double cost){
        productService.update(id, cost);
        return "redirect:/products/" + id;
    }
}
