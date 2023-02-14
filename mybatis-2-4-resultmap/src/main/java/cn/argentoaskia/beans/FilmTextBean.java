package cn.argentoaskia.beans;

public class FilmTextBean {
    private Integer filmId;
    private String filmTitle;
    private String filmDesc;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FilmTextBean{");
        sb.append("filmId=").append(filmId);
        sb.append(", filmTitle='").append(filmTitle).append('\'');
        sb.append(", filmDesc='").append(filmDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getFilmId() {
        return filmId;
    }

    public FilmTextBean setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public FilmTextBean setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
        return this;
    }

    public String getFilmDesc() {
        return filmDesc;
    }

    public FilmTextBean setFilmDesc(String filmDesc) {
        this.filmDesc = filmDesc;
        return this;
    }
}
