/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.peliculas.peliculas.repository;

import com.peliculas.peliculas.entitys.Movie;
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
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM  Movie m WHERE m.title = :title")
    public Movie buscarPorTitulo(@Param("title") String title);

    @Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.name = :name")
    List<Movie> buscarPorActor(@Param("name") String name);

    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE g.name = :name")
    List<Movie> findByGenresName(@Param("name") String name);

    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovies();

}
