package cn.argentoaskia.bean;

public class FilmText {
    private Integer filmId;
    private String title;
    private String description;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FilmText{");
        sb.append("filmId=").append(filmId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public FilmText() {
    }

    public FilmText(Integer filmId, String title, String description) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public FilmText setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FilmText setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FilmText setDescription(String description) {
        this.description = description;
        return this;
    }
}
