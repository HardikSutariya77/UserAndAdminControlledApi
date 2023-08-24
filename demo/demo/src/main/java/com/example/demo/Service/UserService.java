package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductService productService;


    public Product findProductById(int id) {
        return productService.findProductById(id);
    }


    public void createNewUser(User user) {
        userRepository.save(user);
    }
}
