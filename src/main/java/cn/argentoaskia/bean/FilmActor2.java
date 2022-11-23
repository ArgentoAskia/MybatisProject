package cn.argentoaskia.bean;


import java.sql.Timestamp;

public class FilmActor2 {

  private Integer actorId;
  private Integer filmId;
  private Timestamp lastUpdate;


  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("FilmActor2{");
    sb.append("actorId=").append(actorId);
    sb.append(", filmId=").append(filmId);
    sb.append(", lastUpdate=").append(lastUpdate);
    sb.append('}');
    return sb.toString();
  }

  public Integer getActorId() {
    return actorId;
  }

  public FilmActor2 setActorId(Integer actorId) {
    this.actorId = actorId;
    return this;
  }

  public Integer getFilmId() {
    return filmId;
  }

  public FilmActor2 setFilmId(Integer filmId) {
    this.filmId = filmId;
    return this;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public FilmActor2 setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }
}
