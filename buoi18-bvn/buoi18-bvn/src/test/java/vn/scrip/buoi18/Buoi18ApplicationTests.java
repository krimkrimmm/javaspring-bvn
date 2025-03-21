package vn.scrip.buoi18;

import vn.scrip.buoi18.model.Movie;
import vn.scrip.buoi18.repository.MovieRepository;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Random;

@SpringBootTest
class MovieAppTests {

	@Autowired
	private MovieRepository movieRepository;

	@Test
	void saveMovies() {
		Faker faker = new Faker();
		Slugify slugify = Slugify.builder().build();
		Random rd = new Random();
		String[] movieTypes = {"single", "series", "cinema"};

		for (int i = 0; i < 150; i++) {
			// Tạo movie
			String title = faker.funnyName().name();
			String description = faker.lorem().sentence();
			String type = movieTypes[rd.nextInt(movieTypes.length)];

			Movie movie = new Movie(title, description, type);

			// Lưu vào DB
			movieRepository.save(movie);
		}
	}

	@Test
	void testQuery() {
		// Phân trang, sắp xếp theo tên
		Pageable pageable = PageRequest.of(0, 5, Sort.by("title").ascending());
		Page<Movie> moviePage = movieRepository.findByType("single", pageable);

		System.out.println("Total pages: " + moviePage.getTotalPages());
		System.out.println("Total elements: " + moviePage.getTotalElements());

		moviePage.getContent().forEach(movie ->
				System.out.println(movie.getTitle() + " - " + movie.getType())
		);
	}
}
