package ru.cft.shift.quickstart_bus_traffic.entity;

import java.util.HashSet;
import java.util.Objects;

public class BusEntity {
  private Long id;
  private String number;
  private BusModelEntity model;
  private HashSet<PassengerEntity> passengers;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public BusModelEntity getModel() {
    return model;
  }

  public void setModel(BusModelEntity model) {
    this.model = model;
  }

  public HashSet<PassengerEntity> getPassengers() {
    return passengers;
  }

  public void setPassengers(HashSet<PassengerEntity> passengers) {
    this.passengers = passengers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BusEntity busEntity = (BusEntity) o;
    return Objects.equals(id, busEntity.id) &&
        Objects.equals(number, busEntity.number) &&
        Objects.equals(model, busEntity.model) &&
        Objects.equals(passengers, busEntity.passengers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, model, passengers);
  }

  @Override
  public String toString() {
    return "BusEntity{" +
        "id=" + id +
        ", number='" + number + '\'' +
        ", model=" + model +
        ", passengers=" + passengers +
        '}';
  }
}
