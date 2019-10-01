package com.stakroute.repository;

import com.stakroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository //crud methods logic
public interface User1Repository extends JpaRepository <User,Integer>
{

}
