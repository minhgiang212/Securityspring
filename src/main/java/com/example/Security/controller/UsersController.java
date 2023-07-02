package com.example.Security.controller;

import com.example.Security.entity.Role;
import com.example.Security.entity.Users;
import com.example.Security.reponsitory.RoleRepository;
import com.example.Security.reponsitory.UsersResponsitory;
import com.example.Security.security.JwtTokenProvider;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Users")
public class UsersController {
    @Autowired
    UsersResponsitory usersResponsitory;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @GetMapping("/getAll")
        public List<Users> getall(){
        List<Users> getAll=usersResponsitory.findAll();
        return getAll;
    }
    @PostMapping ("/login")
    public String processLogin(@RequestBody Users users, HttpServletResponse response){
        String roleName="";
        List<Users> lstu = usersResponsitory.findAll();
        List<Role> lsRole = roleRepository.findAll();

        if (users != null){
            int i =0;
            for (Users u: lstu ){
                if (u.getUserName().toUpperCase().equals(users.getUserName().toUpperCase())
                        && u.getUserPass().equals(users.getUserPass())
                )
                {
                    for (Role r: lsRole){
                        if(r.getUserId() == u.getUserId()){
                            roleName= r.getRoleName();
                        }
                    }
                    String token = jwtTokenProvider.maHoaDuLieu2(users.getUserName(), roleName);
                    System.out.println("Đăng nhập thành công");
                    response.addHeader("token", token);
                    i ++;
                    return users.toString();

                }

            }
        }

        return "Đã so sánh tất cả các User Đăng nhập không thành công ";
    }


}
