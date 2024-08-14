/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peliculas.peliculas.service;

import com.peliculas.peliculas.entitys.Movie;
import com.peliculas.peliculas.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Crear o actualizar una película
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Obtener todas las películas
    public List<Movie> getAllMovies() {
        return movieRepository.findAllMovies();
    }

    // Obtener una película por ID
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    // Buscar películas por género
    public List<Movie> getMoviesByGenre(String genreName) {
        return movieRepository.findByGenresName(genreName);
    }

    // Eliminar una película por ID
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


}
