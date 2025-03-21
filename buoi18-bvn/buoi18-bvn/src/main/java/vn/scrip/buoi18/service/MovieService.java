package vn.scrip.buoi18.service;
import vn.scrip.buoi18.entity.Movie;
import vn.scrip.buoi18.model.enums.MovieType;
import vn.scrip.buoi18.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public Page<Movie> getMoviesByType(int page, int size) {
        if (page < 0) {
            page = 0; // Đảm bảo page không âm
        }
        return movieRepository.findAll(PageRequest.of(page, size));
    }
}