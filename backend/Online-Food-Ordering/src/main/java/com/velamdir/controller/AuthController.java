package com.velamdir.controller;


import com.velamdir.config.JwtProvider;
import com.velamdir.model.User;
import com.velamdir.repository.CartRepository;
import com.velamdir.repository.UserRepository;
import com.velamdir.response.AuthResponse;
import com.velamdir.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;
   @Autowired
   private JwtProvider jwtProvider;
   @Autowired
   private CustomerUserDetailsService customerUserDetailsService;
   @Autowired
   private CartRepository cartRepository;

   public ResponseEntity<AuthResponse>createUserHandler(@RequestBody User user){
     User isEmailExist = userRepository.findByEmail(user.getEmail());

     return null;
   }
}
