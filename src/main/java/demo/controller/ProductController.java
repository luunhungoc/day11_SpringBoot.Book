package demo.controller;

import demo.entity.Product;
import demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String home() {
        return "fragments/header";
    }
    @GetMapping("/product")
    public String showProductList(Model model) {
        List<Product> productList =  new ArrayList<>((Collection<Product>) productRepository.findAll());
        model.addAttribute("productList", productList);
        return "productList";
    }

    @GetMapping("/product/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.deleteById(id);
        return "redirect:/";
    }
}
