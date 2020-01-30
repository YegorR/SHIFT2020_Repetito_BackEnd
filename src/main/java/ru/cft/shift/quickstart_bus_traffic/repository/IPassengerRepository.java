package ru.cft.shift.quickstart_bus_traffic.repository;

import ru.cft.shift.quickstart_bus_traffic.entity.PassengerEntity;

public interface IPassengerRepository {
  void add(PassengerEntity bus);
  PassengerEntity get(Long id);
}
