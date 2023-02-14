package cn.argentoaskia.bean;

import java.util.Date;

public class Customer {

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

    public Customer setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public Customer setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Customer setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public Integer getActive() {
        return active;
    }

    public Customer setActive(Integer active) {
        this.active = active;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Customer setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Customer setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
