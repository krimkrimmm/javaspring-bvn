package vn.scrip.buoi16_bvn.entity;
import vn.scrip.buoi16_bvn.enums.MovieType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "movies")

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String poster;

    @Column(name = "release_year")
    private Integer releaseYear;

    private Double rating;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    private Boolean status;
    private String trailer;

    @Column(name = "country_id")
    private Integer countryId; // Chưa tạo quan hệ với Country

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Constructors
    public Movie() {}

    public Movie(String name, String slug, String description, String poster, Integer releaseYear,
                 Double rating, MovieType type, Boolean status, String trailer, Integer countryId) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.poster = poster;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.type = type;
        this.status = status;
        this.trailer = trailer;
        this.countryId = countryId;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public MovieType getType() {
        return type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
