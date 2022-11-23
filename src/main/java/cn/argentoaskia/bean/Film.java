package cn.argentoaskia.bean;


import java.sql.Timestamp;

public class Film {

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

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Film{");
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
    sb.append('}');
    return sb.toString();
  }

  public Integer getFilmId() {
    return filmId;
  }

  public Film setFilmId(Integer filmId) {
    this.filmId = filmId;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Film setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Film setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getReleaseYear() {
    return releaseYear;
  }

  public Film setReleaseYear(String releaseYear) {
    this.releaseYear = releaseYear;
    return this;
  }

  public Integer getLanguageId() {
    return languageId;
  }

  public Film setLanguageId(Integer languageId) {
    this.languageId = languageId;
    return this;
  }

  public Integer getOriginalLanguageId() {
    return originalLanguageId;
  }

  public Film setOriginalLanguageId(Integer originalLanguageId) {
    this.originalLanguageId = originalLanguageId;
    return this;
  }

  public Integer getRentalDuration() {
    return rentalDuration;
  }

  public Film setRentalDuration(Integer rentalDuration) {
    this.rentalDuration = rentalDuration;
    return this;
  }

  public Double getRentalRate() {
    return rentalRate;
  }

  public Film setRentalRate(Double rentalRate) {
    this.rentalRate = rentalRate;
    return this;
  }

  public Integer getLength() {
    return length;
  }

  public Film setLength(Integer length) {
    this.length = length;
    return this;
  }

  public Double getReplacementCost() {
    return replacementCost;
  }

  public Film setReplacementCost(Double replacementCost) {
    this.replacementCost = replacementCost;
    return this;
  }

  public String getRating() {
    return rating;
  }

  public Film setRating(String rating) {
    this.rating = rating;
    return this;
  }

  public String getSpecialFeatures() {
    return specialFeatures;
  }

  public Film setSpecialFeatures(String specialFeatures) {
    this.specialFeatures = specialFeatures;
    return this;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public Film setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }
}
