package com.hugo.crudspring;

import com.hugo.crudspring.enums.Category;
import com.hugo.crudspring.model.Course;
import com.hugo.crudspring.model.Lesson;
import com.hugo.crudspring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatasave(CourseRepository courseRepository) {
        return args -> {
            courseRepository.deleteAll();

            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory(Category.BACK_END);

            Lesson l = new Lesson();
            l.setName("Introdução");
            l.setYoutubeUrl("123456789");
            l.setCourse(c);
            c.getLessons().add(l);

            courseRepository.save(c);
        };
    }
}
