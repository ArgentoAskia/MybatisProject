package cn.argentoaskia.beans;

public class FilmInfo {
    private Integer filmId;
    private String filmTitle;
    private String filmDesc;
    private String filmActorFirstName;
    private String filmActorLastName;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FilmInfo{");
        sb.append("filmId=").append(filmId);
        sb.append(", filmTitle='").append(filmTitle).append('\'');
        sb.append(", filmDesc='").append(filmDesc).append('\'');
        sb.append(", filmActorFirstName='").append(filmActorFirstName).append('\'');
        sb.append(", filmActorLastName='").append(filmActorLastName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getFilmId() {
        return filmId;
    }

    public FilmInfo setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public FilmInfo setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
        return this;
    }

    public String getFilmDesc() {
        return filmDesc;
    }

    public FilmInfo setFilmDesc(String filmDesc) {
        this.filmDesc = filmDesc;
        return this;
    }

    public String getFilmActorFirstName() {
        return filmActorFirstName;
    }

    public FilmInfo setFilmActorFirstName(String filmActorFirstName) {
        this.filmActorFirstName = filmActorFirstName;
        return this;
    }

    public String getFilmActorLastName() {
        return filmActorLastName;
    }

    public FilmInfo setFilmActorLastName(String filmActorLastName) {
        this.filmActorLastName = filmActorLastName;
        return this;
    }
}
