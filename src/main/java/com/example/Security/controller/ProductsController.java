package com.example.Security.controller;

import com.example.Security.entity.Products;
import com.example.Security.reponsitory.ProductsResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductsController {
    @Autowired
    ProductsResponsitory productsResponsitory;
    @GetMapping("/getAll1")
    public List<Products> getALL1(){
        List<Products> getAll1= productsResponsitory.findAll();
        return getAll1;
    }
    @PostMapping
    public Products create (@RequestBody Products products){
    return productsResponsitory.save(products);
    }
}
