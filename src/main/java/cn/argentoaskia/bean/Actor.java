package cn.argentoaskia.bean;

public class Actor {
    private Integer actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Actor{");
        sb.append("actorId=").append(actorId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", lastUpdate='").append(lastUpdate).append('\'');
        sb.append('}');
        return sb.toString();
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

    public String getLastUpdate() {
        return lastUpdate;
    }

    public Actor setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
