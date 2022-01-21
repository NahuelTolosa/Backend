package com.app.app.service;

import com.app.app.model.ProductModel;
import com.app.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements Product {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductModel createProduct(ProductModel p) {
        return productRepository.save(p);
    }

    @Override
    public List<ProductModel> getProducts() {
        List<ProductModel> products =  new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public ProductModel getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public ProductModel updateProduct(ProductModel p, Long id) {
        p.setId(id);
        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(ProductModel p, Long id) {
        p.setId(id);
        productRepository.delete(p);
    }

//    public String createProduct(String name,  Double price, String description) {
//        return "Producto creado";
//    }
//
//    public String getProducts() {
//        return "Listado de productos";
//    }
//
//    public String getProduct(Long id) {
//        return "Producto con id: "+id;
//    }
//
//    public String updateProduct(Long id, String name, Double price, String description) {
//        return "Producto con id: "+id+" actualizado.";
//    }
//
//    public String deleteProduct(Long id) {
//        return "Producto con id: "+id+" borrado.";
//    }
}
