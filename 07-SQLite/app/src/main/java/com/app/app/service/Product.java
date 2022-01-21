package com.app.app.service;

import com.app.app.model.ProductModel;

import java.util.List;

public interface Product {
    ProductModel createProduct(ProductModel p);
    List<ProductModel> getProducts();
    ProductModel getProduct(Long id);
    ProductModel updateProduct(ProductModel p, Long id);
    void deleteProduct(ProductModel p, Long id);
}
