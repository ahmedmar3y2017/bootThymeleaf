package com.example.demo.config;

import com.example.demo.Dao.userDao;
import com.example.demo.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    userDao userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user userAuth = userService.findByUsername(username);
        if (userAuth != null) {


            GrantedAuthority authority = new SimpleGrantedAuthority(userAuth.getRole());
            System.out.println(userAuth.getRole());
            System.out.println(authority.getAuthority());
            User user = new User(userAuth.getUsername(), userAuth.getPassword(), Arrays.asList(authority));
            System.out.println(user.getUsername() + " \t  " + user.getPassword() + "\t" + user.getAuthorities());
            UserDetails userDetails = (UserDetails) user;

            return userDetails;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}