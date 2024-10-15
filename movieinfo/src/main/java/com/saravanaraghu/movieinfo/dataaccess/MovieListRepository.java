package com.saravanaraghu.movieinfo.dataaccess;

import com.saravanaraghu.movieinfo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieListRepository extends JpaRepository<Movie, Long> {
    List<Movie> findMoviesByActor(String name);
}
