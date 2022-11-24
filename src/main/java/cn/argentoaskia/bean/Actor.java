package cn.argentoaskia.bean;


import java.sql.Timestamp;

public class Actor {

  private Integer actorId;
  private String firstName;
  private String lastName;
  private java.sql.Timestamp lastUpdate;

  @Override
  public String toString() {
    return "Actor{" +
            "actorId=" + actorId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", lastUpdate=" + lastUpdate +
            '}';
  }

  public Integer getActorId() {
    return actorId;
  }

  public Actor setActorId(Integer actorId) {
    this.actorId = actorId;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Actor setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Actor setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public Actor setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }
}
