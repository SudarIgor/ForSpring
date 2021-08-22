package com.gb.webaapp.homework3.controllers;


import com.gb.webaapp.homework3.model.Product;
import com.gb.webaapp.homework3.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products";
    }

    @GetMapping("/show/{id}")
    public String showProductsPage(Model model, @PathVariable Long id) {
        model.addAttribute("product", productsService.findById(id));
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create_product";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String title, @RequestParam double cost) {
        Product product = new Product(id, title, cost);
        productsService.save(product);
        return "redirect:/products/show_all";
    }

}
