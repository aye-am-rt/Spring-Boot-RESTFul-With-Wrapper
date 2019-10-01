package com.stakroute.repository;

import com.stakroute.domain.Movie;
import com.stakroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>
{

}
