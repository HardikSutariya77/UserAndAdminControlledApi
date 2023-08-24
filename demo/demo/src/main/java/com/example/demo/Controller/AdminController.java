package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @PostMapping("/insertnewproduct")
    public ResponseEntity<String> insertNewProduct(@RequestBody Product product){
                productService.insertNewProduct(product);
        return new ResponseEntity("New Product inserted Successfully ", HttpStatus.CREATED);
    }

    @PostMapping("/createnewuser")
    public ResponseEntity<String> createNewUser(@RequestBody User user){
        userService.createNewUser(user);
        return new ResponseEntity("New User Created Successfully",HttpStatus.CREATED);
    }



    @GetMapping("/getproductById/{id}")
    public Product findProductByid(@PathVariable int id) {
        return productService.findProductById(id);
    }


    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }


}
