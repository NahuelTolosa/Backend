package com.coderhouse.controlleradvice.database;

import com.coderhouse.controlleradvice.model.Product;

import java.util.ArrayList;
import java.util.Optional;

public class Database {

    private ArrayList<Product> products = new ArrayList<>();

    public Database( ) {
        this.products.add(new Product("Product1",1000.00,"Imagen1"));
        this.products.add(new Product("Product2",2000.00,"Imagen2"));
        this.products.add(new Product("Product3",3000.00,"Imagen3"));
        this.products.add(new Product("Product4",4000.00,"Imagen4"));
        this.products.add(new Product("Product5",5000.00,"Imagen5"));
        this.products.add(new Product("Product6",6000.00,"Imagen6"));
        this.products.add(new Product("Product7",7000.00,"Imagen7"));
        this.products.add(new Product("Product8",8000.00,"Imagen8"));
        this.products.add(new Product("Product9",9000.00,"Imagen9"));
    }

    /*CREATE*/
    public Product add(Product productModel) {

        products.add(productModel);

        return productModel;
    }

    /*READ*/
    public ArrayList<Product> getAll() {
        return products;
    }

    public Product getById(String id) {

        Optional<Product> product = products
                .stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst();

        return product.orElse(null);
    }

    /*UPDATE*/
    public boolean update(Product productModel) {

        for (Product p: products) {

            if(p.getId().equals(productModel.getId())){
                p.setTitle(productModel.getTitle());
                p.setPrice(productModel.getPrice());
                p.setThumbnail(productModel.getThumbnail());

                return true;
            }
        }

        return false; // Error 404, not found

    }

    /*DELETE*/
    public boolean delete(String id) {
        return products.remove(getProductById(id));
    }


    /*AUX*/
    private Product getProductById(String id) {

        for (Product p : products) {

            if (p.getId().equals(id)) return p; //Retorna el product }

        }

        return null;
    }
}
