package com.example.springbasic.controllers;

import com.example.springbasic.DTO.ProductDto;
import com.example.springbasic.model.Category;
import com.example.springbasic.services.CategoryService;
import com.example.springbasic.services.ProductService;
import com.example.springbasic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;



    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/json_all")
    @ResponseBody
    public List<Product> productAllJson(){
        return productService.findAll();
    }

    @GetMapping("/json/{id}")
    @ResponseBody
    public Optional<Product> productAllJson(@PathVariable long id){
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
        model.addAttribute("product", Optional.ofNullable(new ProductDto(productService.findById(id).get())));
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
    model.addAttribute("product", new ProductDto(productService.findById(id).get()));
        return "products/update_product";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable long id, @ModelAttribute("product") ProductDto product){
        Product newProduct = new Product();
        newProduct.setId(id);
        newProduct.setTitle(product.getTitle());
        newProduct.setPrice(product.getPrice());
        Category category = categoryService.findByTitle(product.getCategory()).get();
        newProduct.setCategory(category);

        productService.update(newProduct);
        return "redirect:/products/"+ id;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id){
        productService.deleteById(id);
        return "redirect:/products/show_all";
    }

}
