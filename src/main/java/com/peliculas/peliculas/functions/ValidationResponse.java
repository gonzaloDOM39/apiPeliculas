/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peliculas.peliculas.functions;
import com.peliculas.peliculas.entitys.User;
import com.peliculas.peliculas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Clase para validar usuarios.
 */
@Component
public class ValidationResponse {

    private boolean isValid;
    private String message;

    @Autowired
    private UserService userService;

    /**
     * Valida si el usuario está en la lista de usuarios y tiene la contraseña correcta.
     *
     * @param userParameter El usuario a validar.
     * @return True si el usuario es válido, de lo contrario, false.
     */
    public boolean isValid(User userParameter) {
        List<User> users = userService.getAllUsers();  // Asumiendo que este método devuelve una lista de usuarios

        isValid = users.stream()
                .anyMatch(user -> user.getUserName().equals(userParameter.getUserName()) &&
                                  user.getPassword().equals(userParameter.getPassword()));

        return isValid;
    }

    // Getters y Setters para isValid y message
    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

   