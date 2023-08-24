package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/getproductById/{id}")
    public Product findProductByid(@PathVariable(required = true) int id){
        return productService.findProductById(id);
    }

    @GetMapping("/home")
    public String home(){
        return "This is Home Page";
    }



}
