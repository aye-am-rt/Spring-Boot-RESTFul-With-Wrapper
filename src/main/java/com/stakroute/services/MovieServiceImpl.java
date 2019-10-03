package com.stakroute.services;

import com.stakroute.domain.Movie;
import com.stakroute.exceptions.MovieAlreadyExistsException;
import com.stakroute.exceptions.MovieDoesNotExistsException;
import com.stakroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie saveMovie(Movie movieObj) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movieObj.getId()))
        {
            throw new MovieAlreadyExistsException ("Movie id already exists");
        }
        Movie savedMovie= movieRepository.save(movieObj);
        if(savedMovie==null)
        {
            throw new MovieAlreadyExistsException ("Movie id already exists can't save null");
        }
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(int Id) throws MovieDoesNotExistsException {
        List<Movie> allMovieList=movieRepository.findAll();
        Movie findOneMovie=new Movie();
        if(movieRepository.existsById(Id))
        {
            for (int i = 0; i < allMovieList.size(); i++)
            {
                if (allMovieList.get(i).getId() == Id)
                {
                    findOneMovie = allMovieList.get(i);
                }
            }
        }
        else
        {
            throw new MovieDoesNotExistsException("movie does not exists with given id= "+Id);
        }
        if(findOneMovie==null)
            throw new MovieDoesNotExistsException("movie does not exists with given id= "+Id);
        return findOneMovie;
    }

    @Override
    public List<Movie> updateMovieById(Movie newMovieObj) throws MovieDoesNotExistsException {

        if(newMovieObj==null)
        {
            throw new MovieDoesNotExistsException ("Movie can not be null");
        }

        if(movieRepository.existsById(newMovieObj.getId())) {
            Movie oldMovie = getMovieById(newMovieObj.getId());

            oldMovie.setBudget(newMovieObj.getBudget());
            oldMovie.setCasts(newMovieObj.getCasts());
            oldMovie.setCategory(newMovieObj.getCategory());
            oldMovie.setMovieName(newMovieObj.getMovieName());
            oldMovie.setReleaseDate(newMovieObj.getReleaseDate());
        }
        else
        {
            throw new MovieDoesNotExistsException("Movie not found with given id ");
        }
        return getAllMovies();
    }

    @Override
    public List<Movie> deleteMovieById(int Id) throws MovieDoesNotExistsException {
        if(movieRepository.existsById(Id))
        {
            Movie movieToDelete=getMovieById(Id);
            movieRepository.delete(movieToDelete);
        }
        else
        {
            throw new MovieDoesNotExistsException("Movie not found with given id ");
        }

        return getAllMovies();
    }

    @Override
    public Movie patchMovieById(int Id,Movie movie) throws MovieDoesNotExistsException {
        if(movieRepository.existsById(Id))
        {
            Movie oldMovie = getMovieById(Id);
            Movie patchedMovie= movieRepository.save(movie);
            return patchedMovie;
        }
        else
        {
            throw new MovieDoesNotExistsException("movie does not exists with given id= "+Id);
        }
    }

    @Override
    public List<Movie> FindByMovieName(String movieName) throws MovieDoesNotExistsException {

        List<Movie> namedList = movieRepository.findByMovieName(movieName);
        if(namedList==null)
            throw new MovieDoesNotExistsException("movie not found with given name = "+movieName);

        return namedList;
    }
}
