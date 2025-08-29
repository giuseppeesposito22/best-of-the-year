package org.lessons.java.best_of_the_year.controllers;

import java.util.ArrayList;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("name", "Giuseppe Esposito" );
        return "home";
    }


    private ArrayList<Movie> getBestMovies(){
        
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1, "Interstellar"));
        movies.add(new Movie(2, "Inception"));
        movies.add(new Movie(3, "Karate Kid"));
        movies.add(new Movie(4, "The Matrix"));

        return movies;
    }


    private ArrayList<Song> getBestSongs(){
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Bohemian Rhapsody"));
        songs.add(new Song(2, "Imagine"));
        songs.add(new Song(3, "Stairway to Heaven"));
        songs.add(new Song(4, "In the End"));

        return songs;

    }

    @GetMapping("/movies")
    public String movies(Model model){

        StringBuilder movieTitles = new StringBuilder();
       for (Movie movie : getBestMovies()) {
        if(movieTitles.length() > 0){
            movieTitles.append(", ");

        }
        movieTitles.append(movie.getTitle());
       }

       model.addAttribute("movieTitles", movieTitles.toString());


    return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model){

        StringBuilder songTitles = new StringBuilder();

        for (Song song : getBestSongs()) {

            if(songTitles.length() > 0){
                songTitles.append(", ");
            }
            songTitles.append(song.getTitle());
        }

        model.addAttribute("songTitles", songTitles.toString());

    return "songs";
    }

    @GetMapping("/movie/{id}")
    public String movieById(Model model, @PathVariable("id") int id){

        for (Movie movie : getBestMovies()) {
            if(movie.getId() == id){
                
                model.addAttribute("movie", movie);
            }
        }

        return "movieById";

    }



    @GetMapping("/song/{id}")
    public String songById(Model model, @PathVariable("id") int id){

        for (Song song : getBestSongs()) {
            if(song.getId() == id){
                model.addAttribute("song", song);
            }
        }

        return "songById";
    }



}
