package com.example.erecruit.db;

import com.example.erecruit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 * odpowiada za połączenie z db klasa user tabela users
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findUserByUsername(String username);   // wyszukuje po email z db

    @Query("SELECT u FROM User u WHERE u.email = ?1")  // alternatywa dla Optional
    User findUserByEmail(String email);
}
