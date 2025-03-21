package vn.scrip.buoi19bvn.controller.web;

import vn.scrip.buoi19bvn.entity.Movie;
import vn.scrip.buoi19bvn.model.enums.MovieType;
import vn.scrip.buoi19bvn.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class WebController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{type}")
    public String listMovies(@PathVariable String type, @RequestParam(defaultValue = "0") int page, Model model) {
        MovieType movieType = MovieType.valueOf(type.toUpperCase());
        Page<Movie> movies = movieService.getMoviesByType(movieType, page, 6);

        model.addAttribute("movies", movies);
        model.addAttribute("currentPage", page);
        model.addAttribute("type", type);
        return "movies";
    }

    @GetMapping("/detail/{id}")
    public String movieDetail(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id).orElse(null);
        if (movie == null) return "redirect:/movies";

        model.addAttribute("movie", movie);
        model.addAttribute("relatedMovies", movieService.getRelatedMovies(movie.getType()));
        return "movie-detail";
    }
}
