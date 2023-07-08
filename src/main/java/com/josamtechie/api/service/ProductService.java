package com.josamtechie.api.service;

import com.josamtechie.api.model.Product;
import com.josamtechie.api.payload.ProductRequest;
import com.josamtechie.api.payload.ProductResponse;
import com.josamtechie.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setProductType(productRequest.getProductType());
        return repository.save(product);
    }

    public List<ProductResponse> getProducts() {
        List<ProductResponse> responseList =new ArrayList<>();
        ProductResponse productResponse;
        List<Product> productList = repository.findAll();
        for(Product prod: productList){
            productResponse = new ProductResponse();
            productResponse.setId(prod.getId());
            productResponse.setName(prod.getName());
            productResponse.setPrice(prod.getPrice());
            productResponse.setDescription(prod.getDescription());
            productResponse.setProductType(prod.getProductType());
            responseList.add(productResponse);
        }
        return responseList;
    }

    public ProductResponse getProductById(Long id) {
        Product product = repository.findById(id).get();
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
            productResponse.setDescription(product.getDescription());
            productResponse.setProductType(product.getProductType());
            return productResponse;

    }

    public Product updateProduct(Long id, ProductRequest productRequest) {
        Product product = repository.findById(id).get();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setDescription(productRequest.getDescription());
            product.setProductType(productRequest.getProductType());
            return repository.save(product);
    }

    public String deleteProduct(Long id) {
        repository.deleteById(id);
        return "Product "+id+" Deleted successfully !!";
    }
}
