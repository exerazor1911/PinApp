package com.pinapp.challenge.challenge.auth.service;

import com.pinapp.challenge.challenge.auth.dto.request.UserDto;
import com.pinapp.challenge.challenge.auth.entity.UserEntity;
import com.pinapp.challenge.challenge.auth.repository.UserRepository;
import com.pinapp.challenge.challenge.exception.RegisterException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsCustomService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Usuario o contraseña no encontrados");
        }


        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDto userDTO) {
        Optional<UserEntity> existingUser = Optional.ofNullable(userRepository.findByUsername(userDTO.getUsername()));

        if (existingUser.isPresent()) {
            throw new RegisterException("Correo electronico en uso, seleccione otro por favor");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(encoder.encode(userDTO.getPassword()));
        userEntity = userRepository.save(userEntity);

        return userEntity != null;
    }

}
