package cn.argentoaskia.beans;


import java.sql.Timestamp;

public class Store {

  private Integer storeId;
  private Integer managerStaffId;
  private Integer addressId;
  private Timestamp lastUpdate;

  @Override
  public String toString() {
    return "Store{" +
            "storeId=" + storeId +
            ", managerStaffId=" + managerStaffId +
            ", addressId=" + addressId +
            ", lastUpdate=" + lastUpdate +
            '}';
  }

  public Integer getStoreId() {
    return storeId;
  }

  public Store setStoreId(Integer storeId) {
    this.storeId = storeId;
    return this;
  }

  public Integer getManagerStaffId() {
    return managerStaffId;
  }

  public Store setManagerStaffId(Integer managerStaffId) {
    this.managerStaffId = managerStaffId;
    return this;
  }

  public Integer getAddressId() {
    return addressId;
  }

  public Store setAddressId(Integer addressId) {
    this.addressId = addressId;
    return this;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public Store setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }
}
