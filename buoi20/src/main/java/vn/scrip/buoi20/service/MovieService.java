package vn.scrip.buoi20.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.scrip.buoi20.entity.Movie;
import vn.scrip.buoi20.model.enums.MovieType;
import vn.scrip.buoi20.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    @Autowired
    private final MovieRepository movieRepository;

    // Lấy danh sách tất cả phim
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Lấy danh sách phim HOT
    public List<Movie> findHotMovie(Boolean status, Integer limit) {
        return movieRepository.findHotMovie(status, limit);
    }

    // Lấy danh sách phim theo loại
    public Page<Movie> findByType(MovieType type, Boolean status, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("publishedAt").descending());
        return movieRepository.findByTypeAndStatus(type, status, pageable);
    }

    // Lấy chi tiết phim
    public Movie findMovieDetails(Integer id, String slug) {
        return movieRepository.findByIdAndSlugAndStatus(id, slug, true);
    }
}
