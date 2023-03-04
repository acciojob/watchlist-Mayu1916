package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovies(@RequestBody Movies movies){
        movieService.addMovies(movies);
        return new ResponseEntity<>("Movie Added success",HttpStatus.CREATED);//
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("director added success",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Add movie director pair",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movies> getMovieByName(@PathVariable String name){

        Movies movies=movieService.getMovieByName(name);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List> getMoviesByDirectorName(@PathVariable String name){
        List<String> list= movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List> findAllMovies(){
        List<String> list = movieService.findAllMovies();
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @GetMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("Delete success",HttpStatus.CREATED);
    }

    @GetMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("delete success",HttpStatus.CREATED);
    }
}
