package com.stakroute.services;

import com.stakroute.domain.Movie;
import com.stakroute.exceptions.MovieAlreadyExistsException;
import com.stakroute.exceptions.MovieDoesNotExistsException;

import java.util.List;

public interface MovieService {
    public Movie saveMovie(Movie movieObj) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies();
    public Movie getMovieById(int Id) throws MovieDoesNotExistsException;
    public List<Movie> updateMovieById(Movie newMovieObj) throws MovieDoesNotExistsException;
    public List<Movie> deleteMovieById(int Id) throws MovieDoesNotExistsException;
    public Movie patchMovieById(int Id,Movie movie) throws MovieDoesNotExistsException;
}
