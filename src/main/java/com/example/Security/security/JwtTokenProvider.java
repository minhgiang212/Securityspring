package com.example.Security.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtTokenProvider {
    private String maBiMat ="ma_bi_mat_cua_toi";
    private String secretkey ="ma_bi_mat_cua_toi";
    private final long JWT_EXPIRATION = 604800000L;
    public String maHoaDuLieu (String name, String role){
        return "abc";
    }
    public String maHoaDuLieu2 (String name, String role){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        String token = Jwts.builder()
                .setSubject(name)
                .claim("roleX",role)
                .claim("nameX", name)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS384, secretkey)
                .compact();
        ;
        System.out.println("Token = " + token);
        return token ;
    }
//    public Claims giaiMaDuLieu(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(secretkey)
//                .parseClaimsJws(token)
//                .getBody();
//        return claims;
//
//    }
//    public static void main(String[] args) {
//        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJIdXkiLCJyb2xlIjoiYWRtaW4iLCJpYXQiOjE2ODc5NTg4NDksImV4cCI6MTY4ODU2MzY0OX0.1rJZ45efVV7JeCTTjwKUa73GtOEbLVNQlzPNRKKgyj1WevadB9dD9LhBUA3DQPa6"; // Thay thế bằng chuỗi JWT cần giải mã
//
//            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
//            Claims claims = jwtTokenProvider.giaiMaDuLieu(token);
//
//            String name = claims.getSubject();
//            String role = claims.get("role", String.class);
//
//            System.out.println("Name: " + name);
//            System.out.println("Role: " + role);
//
//    }
//    public boolean validateAcessToken(String token){
//        try { Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token);
//            return true;
//        }
//    }
    public String getClaimFromToken(String key, String token) {
    String  object = Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody().get(key).toString() ;

    return object; }
    public String getSubjectFromToken( String token) {
        String  object = Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody().getSubject() ;
        return object;
    }





}