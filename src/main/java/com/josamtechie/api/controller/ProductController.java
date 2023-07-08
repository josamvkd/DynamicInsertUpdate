package com.josamtechie.api.controller;

import com.josamtechie.api.model.Product;
import com.josamtechie.api.payload.ProductRequest;
import com.josamtechie.api.payload.ProductResponse;
import com.josamtechie.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody ProductRequest productRequest){
    return  service.addProduct(productRequest);
    }

    @GetMapping
    public List<ProductResponse> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody ProductRequest productRequest){
        return service.updateProduct(id,productRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return service.deleteProduct(id);
    }

}
