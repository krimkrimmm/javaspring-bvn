package vn.scrip.buoi19bvn.service;

import vn.scrip.buoi19bvn.entity.Movie;
import vn.scrip.buoi19bvn.model.enums.MovieType;
import vn.scrip.buoi19bvn.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Page<Movie> getMoviesByType(MovieType type, int page, int size) {
        return movieRepository.findByType(type, PageRequest.of(page, size));
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getRelatedMovies(MovieType type) {
        return movieRepository.findTop6ByTypeAndStatusOrderByRatingDesc(type, true);
    }
}
