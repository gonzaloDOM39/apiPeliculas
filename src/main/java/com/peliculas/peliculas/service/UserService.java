/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peliculas.peliculas.service;

import com.peliculas.peliculas.entitys.User;
import com.peliculas.peliculas.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class UserService {
     @Autowired
    private UserRepository userRepository;
     
       // Crear o actualizar un usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }
public User getUserByUsername(String name){
    return userRepository.findUserByName(name);
}
        // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }
}
