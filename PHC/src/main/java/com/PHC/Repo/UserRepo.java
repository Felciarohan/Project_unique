package com.PHC.Repo;

import com.PHC.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    // Correct method signature to find a user by email
      User findByEmail(String email);
}
