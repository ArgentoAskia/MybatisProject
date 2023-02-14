package cn.argentoaskia.bean;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.List;

public class Country {
    private Integer countryId;
    private String country;
    private Timestamp lastUpdate;
    private List<City> cityList;

    @Override
    public String toString() {
        return "Country{" + "\n" +
                "   countryId=" + countryId + ",\n" +
                "   country='" + country + '\'' + ",\n" +
                "   lastUpdate=" + lastUpdate + ",\n" +
                "   cityList="+ cityList.size() +"[\n" + printList() + "   ]\n" +
                '}';
    }
    private String printList(){
        StringBuilder stringBuilder = new StringBuilder();
        cityList.forEach(city -> stringBuilder.append("        ").append(city.toString()).append(",\n"));
        return stringBuilder.toString();
    }

    public Integer getCountryId() {
        return countryId;
    }

    public Country setCountryId(Integer countryId) {
        this.countryId = countryId;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Country setCountry(String country) {
        this.country = country;
        return this;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Country setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public Country setCityList(List<City> cityList) {
        this.cityList = cityList;
        return this;
    }
}
