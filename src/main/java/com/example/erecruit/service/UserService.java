//package com.example.erecruit.service;
//
//import com.example.erecruit.db.UserRepository;
//import com.example.erecruit.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//@Service
/**
 *  Bedzie przydatne jeśli zrobimy z tego bufor miedzy UserRepository a innymi klasami
 */
//public class UserService {
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public void addNewUser(User user) {
//        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());
//        if (userOptional.isPresent()) {
//            throw new IllegalStateException("użytkownik z tym emailem już istnieje");
//        }
//        userRepository.save(user);
//    }
//}
