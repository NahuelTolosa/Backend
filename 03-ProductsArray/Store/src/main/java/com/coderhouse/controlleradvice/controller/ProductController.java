package com.coderhouse.controlleradvice.controller;

import com.coderhouse.controlleradvice.model.Product;
import com.coderhouse.controlleradvice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "/{id}")
    public Product getProduct (@PathVariable String id ) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product p) {
        return productService.create(p);
    }

    @PutMapping
    public String updateProduct ( @RequestBody Product p ) {

        return (productService.updateProduct(p))
                ? "El producto fue actualizado correctamente"
                : "El producto no pudo ser actualizado";

    }

    @DeleteMapping(path = "/{id}")
    public String deleteProduct (@PathVariable String id) {

        return (productService.deleteProduct(id))
                ? "El producto fue eliminado correctamente"
                : "El producto no pudo ser eliminado";

    }
}
