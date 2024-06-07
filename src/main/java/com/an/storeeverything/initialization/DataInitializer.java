package com.an.storeeverything.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.an.storeeverything.models.UserEntity;
import com.an.storeeverything.models.RolesEntity;
import com.an.storeeverything.repository.RolesRepository;
import com.an.storeeverything.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    CommandLineRunner init(UserRepository userRepository, RolesRepository rolesRepository) {
        return args -> {
            // Tworzenie ról, jeśli jeszcze nie istnieją
            if (rolesRepository.count() == 0) {
                RolesEntity userRole = new RolesEntity();
                userRole.setName("user");
                RolesEntity adminRole = new RolesEntity();
                adminRole.setName("admin");
                rolesRepository.saveAll(Arrays.asList(userRole, adminRole));
            }
        };
    }
}