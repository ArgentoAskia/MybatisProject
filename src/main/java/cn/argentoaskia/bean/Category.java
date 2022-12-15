package cn.argentoaskia.bean;

import java.util.Date;

public class Category {
    private Integer categoryId;
    private String name;
    private Date lastUpdate;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("categoryId=").append(categoryId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append('}');
        return sb.toString();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Category setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Category setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
