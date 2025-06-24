package com.ecomarket;

import com.ecomarket.model.*;
import com.ecomarket.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private Usuariorepository usuariorepository;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();
        // Generar estudiantes
        for (int i = 0; i < 50; i++) {
            Usuario usuario = new Usuario();
            usuario.setId(i + 1);
            usuario.setusername(faker.username().valid());
            usuariorepository.save(usuario);
        
        }
    }
}
