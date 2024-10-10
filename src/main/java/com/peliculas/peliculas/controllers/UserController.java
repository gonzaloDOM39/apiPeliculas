/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peliculas.peliculas.controllers;

import com.peliculas.peliculas.entitys.User;
import com.peliculas.peliculas.functions.ValidationResponse;
import com.peliculas.peliculas.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Permite solicitudes de cualquier origen
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ValidationResponse validation;

    @PostMapping
    public User crearUsuario(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/validate")
    public ResponseEntity<User> validateUser(@RequestBody User user) {
        System.out.println("username:" + user.getUserName() + " password:" + user.getPassword());
        try {

            User existingUser = userService.getUserByUsername(user.getUserName());
            System.out.println("existing user:" + existingUser.getUserName());
            if (existingUser != null && validation.isValid(user)) {
                // Generar token de autenticación
                /*   String token = Jwts.builder()
                    .setSubject(user.getUsername())
                    .setExpiration(Duration.ofMinutes(30))
                    .signWith(SignatureAlgorithm.HS256, "secretkey")
                    .compact();
            user.setToken(token);*/
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            // Manejar errores de base de datos, validación, etc.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
