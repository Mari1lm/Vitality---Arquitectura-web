package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Users;
import com.example.vitality.repositories.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(JwtUserDetailsService.class);

    @Autowired
    private IUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Cargando usuario: {}", username);
        Users user = repo.findByUsername(username);

        if (user == null) {
            log.error("Usuario no encontrado: {}", username);
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        log.info("Usuario encontrado: id={}, enabled={}", user.getId(), user.getEnabled());

        List<GrantedAuthority> roles = new ArrayList<>();
        try {
            user.getRoles().forEach(rol -> {
                log.info("Rol cargado: {}", rol.getRol());
                roles.add(new SimpleGrantedAuthority(rol.getRol()));
            });
        } catch (Exception e) {
            log.error("Error cargando roles del usuario {}: {}", username, e.getMessage(), e);
        }

        log.info("Total roles cargados: {}", roles.size());

        UserDetails ud = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                user.getEnabled(), true, true, true, roles);

        return ud;
    }
}