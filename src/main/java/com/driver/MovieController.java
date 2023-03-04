package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    // 1
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie Added success",HttpStatus.CREATED);//
    }

    // 2
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("director added success",HttpStatus.CREATED);
    }

    // 3
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Add movie director pair",HttpStatus.CREATED);
    }


    // 4
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){

        Movie movie =movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    // 5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    // 6
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
        List<String> list= movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
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
