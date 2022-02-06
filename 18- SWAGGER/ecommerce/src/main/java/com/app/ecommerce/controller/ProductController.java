package com.app.ecommerce.controller;

import com.app.ecommerce.model.ProductModel;
import com.app.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Método para ver un listado de productos",
            description = "Permite ver productos del E-Commerce",
            tags = {"product"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se muestra la lista correctamente"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado", content = @Content)
            }
    )
    @GetMapping("/all")
    public List<ProductModel> findAll() {
        return this.productService.findAll();
    }


    @Operation(summary = "Método para ver un producto",
            description = "Permite ver un producto del E-Commerce segun el nombre pasado por parametro",
            tags = {"product"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se muestra el producto correctamente"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado", content = @Content)
            }
    )
    @GetMapping("/product")
    public ProductModel findByName(@RequestParam String name) {
        return this.productService.findByName(name);
    }


    @Operation(summary = "Método para ver un listado de productos",
            description = "Permite ver productos del E-Commerce segun la categoria que se pase por parametro",
            tags = {"product"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se muestra la lista correctamente"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado", content = @Content)
            }
    )
    @GetMapping
    public List<ProductModel> findByCategory(@RequestParam String category) {
        return this.productService.findByCategory(category);
    }


}
