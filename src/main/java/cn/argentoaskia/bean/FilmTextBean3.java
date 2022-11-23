package cn.argentoaskia.bean;

public class FilmTextBean3 {
    private Integer filmId;
    private String filmTitle;
    private String filmDescription;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FilmTextBean2{");
        sb.append("filmId=").append(filmId);
        sb.append(", filmTitle='").append(filmTitle).append('\'');
        sb.append(", filmDescription='").append(filmDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getFilmId() {
        return filmId;
    }

    public FilmTextBean3 setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public FilmTextBean3 setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
        return this;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public FilmTextBean3 setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
        return this;
    }
}
