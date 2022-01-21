package com.app.app.controller;

import com.app.app.model.ProductModel;
import com.app.app.service.ProductService;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;


    @GetMapping
    public List<ProductModel> getProducts ( ) {
        logger.info("CONTROLLER: Obtención de productos");
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public ProductModel getProduct ( @PathVariable Long id) {
        logger.info("CONTROLLER: Obtención del producto con id: "+id);
        return productService.getProduct(id);
    }

    @PostMapping
    public ProductModel createProduct ( @RequestBody ProductModel c) {
        logger.info("CONTROLLER: Creacion de producto.");
        return productService.createProduct(c);
    }

    @PutMapping(value = "/product/{id}")
    public ProductModel updateProduct ( @RequestBody ProductModel p, @PathVariable Long id) {
        logger.info("CONTROLLER: Actualizacion de producto con id: "+id);
        return productService.updateProduct(p, id);
    }

    @DeleteMapping(value = "/product/{id}")
    public void deleteProduct (ProductModel p, @PathVariable Long id) {
        logger.info("CONTROLLER: Eliminación de producto con id: "+id);
        productService.deleteProduct(p, id);
    }
}
