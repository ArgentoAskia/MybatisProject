package cn.argentoaskia.bean;

import java.util.Date;

public class Customer2 {

    private Integer customerId;
    private Integer storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer addressId;
    private Integer active;
    private Date createDate;
    private Date lastUpdate;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("customerId=").append(customerId);
        sb.append(", storeId=").append(storeId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", addressId=").append(addressId);
        sb.append(", active=").append(active);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append('}');
        return sb.toString();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Customer2 setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public Customer2 setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer2 setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer2 setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer2 setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Customer2 setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public Integer getActive() {
        return active;
    }

    public Customer2 setActive(Integer active) {
        this.active = active;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Customer2 setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Customer2 setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
