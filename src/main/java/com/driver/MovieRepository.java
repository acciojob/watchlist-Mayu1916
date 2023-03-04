package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String, Movie> moviesMap = new HashMap<>();
    Map<String,Director> directorMap = new HashMap<>();

    Map<String, List<String>> DirectorMovies = new HashMap<>();

    public String addMovie(Movie movie){
        moviesMap.put(movie.getName(), movie);
        return "movie added";
    }
    public String addDirector(Director director){
        directorMap.put(director.getName(),director);
        return "director added";
    }

    public String addMovieDirectorPair(String movie,String director){

        if(!moviesMap.containsKey(movie) || !directorMap.containsKey(director)){
            return "Movie or Director not found in database";
        }
        if(DirectorMovies.containsKey(director)){
            List<String> a= DirectorMovies.get(director);
            if(a.contains(movie)) return "already present pair";
            a.add(movie);
        }
        else{
            List<String> a = new ArrayList<>();
            a.add(movie);
            DirectorMovies.put(director,a);
        }
        return "Pair added successively";
    }

    public Movie getMovieByName(String name){
        if(moviesMap.containsKey(name)) return moviesMap.get(name);
        return null;
    }

    public Director getDirectorByName(String name){
        if(directorMap.containsKey(name)) return directorMap.get(name);
        return null;
    }

    public  List getMoviesByDirectorName(String director){
        if(DirectorMovies.containsKey(director)) return DirectorMovies.get(director);
        return null;
    }

    public List findAllMovies(){
        List<String> list = new ArrayList<>();
        for(String x : moviesMap.keySet()){
            list.add(x);
        }
        return list;
    }
    public  String deleteDirectorByName(String director){
        List<String> a = DirectorMovies.get(director);
        for (int i=0;i<a.size();i++){
            moviesMap.remove(a.get(i));
        }
        directorMap.remove(director);
        DirectorMovies.remove(director);
        return "delete done";
    }

    public String deleteAllDirectors(){
        for(String x : DirectorMovies.keySet()){
            List<String> a = DirectorMovies.get(x);
            for(int i=0;i<a.size();i++){
                moviesMap.remove(a.get(i));
            }
            directorMap.remove(x);
        }
//        DirectorMovies.clear();
        return "Deleted all ";
    }




}
