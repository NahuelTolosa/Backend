package com.coderhouse.controlleradvice.repository;

import com.coderhouse.controlleradvice.database.Database;
import com.coderhouse.controlleradvice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepository {

    private Database database = new Database();

    /*CREATE*/
    public Product create (Product p ) {
        return database.add(p);
    }

    /*READ*/
    public ArrayList<Product> getProducts( ) {
        return database.getAll();
    }
    public Product getProduct ( String id ) {
        return database.getById( id );
    }

    /*UPDATE*/
    public boolean updateProduct (Product productModel) {
        return database.update(productModel);
    }

    /*DELETE*/
    public boolean deleteProduct ( String id ) {
        return database.delete(id);
    }
}
