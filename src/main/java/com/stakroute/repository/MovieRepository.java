package com.stakroute.repository;

import com.stakroute.domain.Movie;
import com.stakroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>
{
    @Query("select m from Movie m where m.movieName like ?1")
    List<Movie> findByMovieName(String movieName);

}
