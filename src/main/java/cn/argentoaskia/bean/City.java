package cn.argentoaskia.bean;

import java.sql.Timestamp;

public class City {
    private Integer cityId;
    private String city;
    private Integer countryId;
    private Timestamp lastUpdate;

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public Integer getCityId() {
        return cityId;
    }

    public City setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getCity() {
        return city;
    }

    public City setCity(String city) {
        this.city = city;
        return this;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public City setCountryId(Integer countryId) {
        this.countryId = countryId;
        return this;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public City setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
