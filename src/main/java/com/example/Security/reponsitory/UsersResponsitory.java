package com.example.Security.reponsitory;

import com.example.Security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersResponsitory extends JpaRepository<Users,Integer> {
}
