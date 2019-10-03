package com.stakroute.controller;

import com.stakroute.domain.Movie;
import com.stakroute.exceptions.MovieAlreadyExistsException;
import com.stakroute.exceptions.MovieDoesNotExistsException;
import com.stakroute.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/v2")
public class MovieController {
    private MovieService movieService;  //Interface

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> saveMovieHttpPostHandler(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);
            responseEntity=new ResponseEntity<String>("Successfully Added Movie", HttpStatus.CREATED);
        }
        catch (MovieAlreadyExistsException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }


    @GetMapping("/movies")
    public ResponseEntity<?> getAllMoviesHttpHandler()
    {
        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;

    }

    @GetMapping("/movie")
    public ResponseEntity<?> getMovieByIdHttpHandler(@PathVariable Integer Id)
    {
        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity<Movie>(movieService.getMovieById(Id),HttpStatus.OK);
        }
        catch (MovieDoesNotExistsException ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/movie")
    public ResponseEntity<?> updateMovieByIdHttpHandler(@RequestBody Movie movieToUpdate)
    {
        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity<List<Movie>>(movieService.updateMovieById(movieToUpdate),HttpStatus.OK);
        }
        catch (MovieDoesNotExistsException ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("/movie/{Id}")
    public ResponseEntity<?> deleteMovieByIdHttpHandler(@PathVariable Integer Id)
    {
        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity<List<Movie>>(movieService.deleteMovieById(Id),HttpStatus.OK);
        }
        catch (MovieDoesNotExistsException ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PatchMapping("/movie/{Id}")
    public ResponseEntity<?> patchMovieByIdHttpHandler(@RequestBody Movie movieToPatch,@PathVariable Integer Id)
    {
        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity<Movie>(movieService.patchMovieById(Id,movieToPatch),HttpStatus.OK);
        }
        catch (MovieDoesNotExistsException ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/movies/search")
    public ResponseEntity<?> getMovieByNameHttpHandler(@RequestParam String movieName)
    {
        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity<List<Movie>>(movieService.FindByMovieName(movieName),HttpStatus.OK);
        }
        catch (MovieDoesNotExistsException ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

}
