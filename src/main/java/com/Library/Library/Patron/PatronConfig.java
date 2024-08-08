package com.Library.Library.Patron;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PatronConfig {
    @Bean
    CommandLineRunner commandLineRunnerPatron(
            PatronRepository patronRepository
    ){
        return args -> {
            Patron patron1= new Patron(
                    "Ahmed",
                    "Ahmed@gmail.com",
                    "+20106445589",
                    "Aswan",
                    "566655"
            );
            Patron patron2= new Patron(
                    "Mohammed",
                    "Mohammed@gmail.com",
                    "+20106444489",
                    "Tant",
                    "135755"
            );
            patronRepository.saveAll(
                    List.of(patron1,patron2)
            );
        };
    }
}
