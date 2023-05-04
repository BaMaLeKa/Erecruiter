package com.example.erecruit.db;

import com.example.erecruit.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * odpowiada za połączenie z db klasa student tabela student
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // wyszukiwanie po email
    List<Student> findByEmail(String email);


    // wyszukiwanie po ostatnim id
    List<Student> findTopByOrderByIdDesc();


}
