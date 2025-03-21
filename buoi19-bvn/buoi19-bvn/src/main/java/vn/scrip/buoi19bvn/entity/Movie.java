package vn.scrip.buoi19bvn.entity;

import vn.scrip.buoi19bvn.model.enums.MovieType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String director;
    private String thumbnail;
    private String trailer;
    private double rating;
    private boolean status;

    @Enumerated(EnumType.STRING)
    private MovieType type;
}
