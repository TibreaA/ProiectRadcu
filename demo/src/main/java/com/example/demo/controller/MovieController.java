package com.example.demo.controller;

import com.example.demo.Movie;
import com.example.demo.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/movies")
    public String saveProduct(@RequestBody Movie movie) throws ExecutionException, InterruptedException {

        return service.saveMovie(movie);
    }

}
