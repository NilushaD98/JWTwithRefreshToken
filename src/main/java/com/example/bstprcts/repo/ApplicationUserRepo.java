package com.example.bstprcts.repo;

import com.example.bstprcts.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepo extends JpaRepository<ApplicationUser,Integer> {

    @Query(value = "SELECT * FROM application_User WHERE user_name= ?1 ",nativeQuery = true)
    Optional<ApplicationUser> findByUsername(String username);
}
