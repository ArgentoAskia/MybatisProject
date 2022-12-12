package cn.argentoaskia.beans;


import java.sql.Timestamp;

public class Inventory {

  private Integer inventoryId;
  private Timestamp lastUpdate;
  private Object filmOrStore;


  @Override
  public String toString() {
    return "Inventory{" +
            "inventoryId=" + inventoryId +
            ", lastUpdate=" + lastUpdate +
            ", filmOrStore=" + filmOrStore +
            '}';
  }

  public Integer getInventoryId() {
    return inventoryId;
  }

  public Inventory setInventoryId(Integer inventoryId) {
    this.inventoryId = inventoryId;
    return this;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public Inventory setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  public Object getFilmOrStore() {
    return filmOrStore;
  }

  public Inventory setFilmOrStore(Object filmOrStore) {
    this.filmOrStore = filmOrStore;
    return this;
  }
}
