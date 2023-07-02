package com.example.Security.reponsitory;

import com.example.Security.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsResponsitory extends JpaRepository<Products,Integer> {
}
