package cn.argentoaskia.bean;

import java.sql.Timestamp;

public class FilmActor {
    private Integer filmId;
    private String title;
    private String description;
    private String releaseYear;
    private Integer languageId;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private String specialFeatures;
    private Timestamp lastUpdate;
    // 单个实体类对象
    private Actor actor;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FilmActor{");
        sb.append("filmId=").append(filmId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", releaseYear='").append(releaseYear).append('\'');
        sb.append(", languageId=").append(languageId);
        sb.append(", originalLanguageId=").append(originalLanguageId);
        sb.append(", rentalDuration=").append(rentalDuration);
        sb.append(", rentalRate=").append(rentalRate);
        sb.append(", length=").append(length);
        sb.append(", replacementCost=").append(replacementCost);
        sb.append(", rating='").append(rating).append('\'');
        sb.append(", specialFeatures='").append(specialFeatures).append('\'');
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", actor=").append(actor);
        sb.append('}');
        return sb.toString();
    }

    public Integer getFilmId() {
        return filmId;
    }

    public FilmActor setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FilmActor setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FilmActor setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public FilmActor setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public FilmActor setLanguageId(Integer languageId) {
        this.languageId = languageId;
        return this;
    }

    public Integer getOriginalLanguageId() {
        return originalLanguageId;
    }

    public FilmActor setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
        return this;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public FilmActor setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
        return this;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public FilmActor setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public FilmActor setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public FilmActor setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public FilmActor setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public FilmActor setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
        return this;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public FilmActor setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public Actor getActor() {
        return actor;
    }

    public FilmActor setActor(Actor actor) {
        this.actor = actor;
        return this;
    }
}
