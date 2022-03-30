package com.example.intc_backend.config;

import com.example.intc_backend.model.User;
import com.example.intc_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

//    public static final String USER = "USER";
//    public static final String ROLE_USER = "ROLE_" + USER;

    private final UserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(final String phoneNumber) {
        final User user = Optional.ofNullable(userRepository.findByPhoneNumber(phoneNumber))
                .orElseThrow(() -> new UsernameNotFoundException("User " + phoneNumber + " not found"));
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.emptyList();
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getPhoneNumber();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

}