package vn.scrip.buoi18.controller.web;

import vn.scrip.buoi18.entity.Movie;
import vn.scrip.buoi18.model.enums.MovieType;
import vn.scrip.buoi18.service.MovieService;
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

    @GetMapping("/movies")
    public String listMoviesByType(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        if (page < 0) {
            page = 0; // Đảm bảo page không âm
        }
        Page<Movie> movies = movieService.getMoviesByType(page, size);
        model.addAttribute("movies", movies);
        return "movies";
    }
}