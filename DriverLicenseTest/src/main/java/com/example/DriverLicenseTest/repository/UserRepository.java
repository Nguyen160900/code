package com.example.DriverLicenseTest.repository;

import com.example.DriverLicenseTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    @Query("select (count(u) > 0) from User u where u.username = ?1")
    boolean existsByUsername(String username);
}
