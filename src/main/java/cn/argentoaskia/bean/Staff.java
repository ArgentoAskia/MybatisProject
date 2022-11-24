package cn.argentoaskia.bean;


import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Staff {

  private Integer staffId;
  private String firstName;
  private String lastName;
  private Integer addressId;
  private InputStream picture;
  private String email;
  private Integer storeId;
  private Boolean active;
  private String username;
  private String password;
  private LocalDateTime lastUpdate;


  @Override
  public String toString() {
    return "Staff{" +
            "staffId=" + staffId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", addressId=" + addressId +
            ", picture=" + picture +
            ", email='" + email + '\'' +
            ", storeId=" + storeId +
            ", active=" + active +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", lastUpdate=" + lastUpdate +
            '}';
  }

  public Integer getStaffId() {
    return staffId;
  }

  public Staff setStaffId(Integer staffId) {
    this.staffId = staffId;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Staff setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Staff setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Integer getAddressId() {
    return addressId;
  }

  public Staff setAddressId(Integer addressId) {
    this.addressId = addressId;
    return this;
  }

  public InputStream getPicture() {
    return picture;
  }

  public Staff setPicture(InputStream picture) {
    this.picture = picture;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Staff setEmail(String email) {
    this.email = email;
    return this;
  }

  public Integer getStoreId() {
    return storeId;
  }

  public Staff setStoreId(Integer storeId) {
    this.storeId = storeId;
    return this;
  }

  public Boolean getActive() {
    return active;
  }

  public Staff setActive(Boolean active) {
    this.active = active;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public Staff setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Staff setPassword(String password) {
    this.password = password;
    return this;
  }

  public LocalDateTime getLastUpdate() {
    return lastUpdate;
  }

  public Staff setLastUpdate(LocalDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }
}
