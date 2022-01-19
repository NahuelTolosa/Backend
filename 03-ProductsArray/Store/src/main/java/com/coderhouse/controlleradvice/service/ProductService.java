package com.coderhouse.controlleradvice.service;

import com.coderhouse.controlleradvice.model.Product;
import com.coderhouse.controlleradvice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /*CREATE*/
    public Product create (Product p ) {
        return productRepository.create(p);
    }

    /*READ*/
    public ArrayList<Product> getProducts ( ) {
        return productRepository.getProducts();
    }
    public Product getProduct ( String id ) {
        return productRepository.getProduct(id);
    }

    /*UPDATE*/
    public boolean updateProduct (Product p) {
        return productRepository.updateProduct(p);
    }

    /*DELETE*/
    public boolean deleteProduct ( String id ) {
        return productRepository.deleteProduct(id);
    }
}
