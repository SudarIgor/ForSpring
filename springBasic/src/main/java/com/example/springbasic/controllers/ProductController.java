package com.example.springbasic.controllers;

import com.example.springbasic.model.User;
import com.example.springbasic.services.ProductService;
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

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/products/show_all";
    }

    @GetMapping ("/{id}/change_price")
    public String changeCost(@PathVariable long id, @RequestParam double price){
        productService.updatePrice(id, price);
        return "redirect:/products/" + id;
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable long id,  Model model){
    model.addAttribute("product", productService.findById(id));
        return "products/update_product";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable long id, @ModelAttribute("product") Product product){
        System.out.println(id);
        product.setId(id);
        System.out.println(product);
        productService.update(product);
        return "redirect:/products/"+ id;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id){
        productService.delete(id);
        return "redirect:/products/show_all";
    }

    @GetMapping("/{id}/users")
    @ResponseBody
    public List<User> showUsers( @PathVariable long id){
        return productService.showUsers(id);
    }
}
