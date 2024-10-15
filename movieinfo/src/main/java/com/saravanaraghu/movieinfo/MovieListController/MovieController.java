package com.saravanaraghu.movieinfo.MovieListController;

import com.saravanaraghu.movieinfo.dataaccess.MovieListRepository;
import com.saravanaraghu.movieinfo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieListRepository movieListRepository;

    @RequestMapping(method = RequestMethod.GET,value = "/movies/{actor}")
    public String getMovieListByActor(@PathVariable("actor") String name, Model model){

        /*List<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie();
        movie.setActor("Ajitheyy");
        movie.setDescription("Mangatha is 50th film");
        movie.setName("Mangatha");
        movies.add(movie);*/
        List<Movie> movieList = movieListRepository.findMoviesByActor(name);
        model.addAttribute("movies",movieList);
        return "movieList";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/movies", consumes = "application/json")
    public ResponseEntity<Object> addMovie(@RequestBody Movie movie){
        movieListRepository.save(movie);
        return ResponseEntity.ok().build();
    }
}
