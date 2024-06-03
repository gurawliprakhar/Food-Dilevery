package com.velamdir.service;

import com.velamdir.model.USER_ROLE;
import com.velamdir.model.User;
import com.velamdir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user by email (username)
        User user = userRepository.findByEmail(username);
        if (user == null) {
            // If user not found, throw an exception
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        // Fetch the role of the user
        USER_ROLE role = user.getRole();
        if (role == null) {
            role = USER_ROLE.ROLE_CUSTOMER; // Default role if not assigned
        }

        // Convert the user's role to a GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));

        // Return a UserDetails object with the user's email, password, and role
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
