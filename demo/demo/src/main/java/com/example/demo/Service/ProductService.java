package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void insertNewProduct(Product product) {
        productRepository.save(product);
    }

    public Product findProductById(int id){
        Product p= productRepository.findById(id).orElse(null);
        try{
            if(p!=null) {
                return p;
            }
        } catch (Exception e) {
           throw new RuntimeException("Product Not Found");
        }
        return p;
    }
}
