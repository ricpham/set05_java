package com.fpt.set05_ngocthach.services;

import com.fpt.set05_ngocthach.models.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAll();

    public List<Product> getAll(String keyword);

    public Product getProductById(String id);

    public boolean addProduct(Product product);

    public boolean updateProduct(Product product);

    public boolean deleteProduct(String id);
}
