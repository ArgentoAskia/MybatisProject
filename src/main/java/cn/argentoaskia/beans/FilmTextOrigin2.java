package cn.argentoaskia.beans;


// 1. 创建实体类
public class FilmTextOrigin2 {

    private Integer film_id;
    private String title;
    private String description;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FilmText{");
        sb.append("film_id=").append(film_id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getFilm_id() {
        return film_id;
    }

    public FilmTextOrigin2 setFilm_id(Integer film_id) {
        this.film_id = film_id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FilmTextOrigin2 setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FilmTextOrigin2 setDescription(String description) {
        this.description = description;
        return this;
    }
}
