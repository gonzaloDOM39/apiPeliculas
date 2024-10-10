/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.peliculas.peliculas.repository;

import com.peliculas.peliculas.entitys.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user")
    List<User> findAllUsers();

@Query("SELECT u FROM User u WHERE u.userName = :userName")
User findUserByName(@Param("userName") String userName);

}
