package com.locnht.SpringBootAndSpringDataJpa;

import com.github.javafaker.Faker;
import com.locnht.SpringBootAndSpringDataJpa.models.Author;
import com.locnht.SpringBootAndSpringDataJpa.models.Video;
import com.locnht.SpringBootAndSpringDataJpa.repositories.AuthorRepository;
import com.locnht.SpringBootAndSpringDataJpa.repositories.VideoRepository;
import com.locnht.SpringBootAndSpringDataJpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;

@SpringBootApplication
public class SpringBootAndSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAndSpringDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	) {
		return args -> {
			/*for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstname(faker.name().firstName())
						.lastname(faker.name().lastName())
						.email(faker.name().username() + "@gmail.com")
						.age(faker.number().numberBetween(20, 90))
						.build();
				authorRepository.save(author);
			}*/

			// update author with ID = 1
			var author = Author.builder()
					.id(1)
					.firstname("Loc")
					.lastname("Ngo")
					.email("locnht1@gmail.com")
					.age(33)
					.build();
			authorRepository.save(author);

			// update Author a set a.age = 22 where a.id = 1
			authorRepository.updateAuthor(100, 1);

			// update all authors
			//authorRepository.updateAllAuthorsAges(99);

			/*var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);*/

			// find by named query
//			authorRepository.findByNamedQuery(70)
//					.forEach(System.out::println);

			// update with named query
//			authorRepository.updateByNamedQuery(12);

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(44))
					.or(AuthorSpecification.firstnameLike("e"))
					;
			authorRepository.findAll(spec).forEach(System.out::println);

		};
	}
}
