package ru.cft.shift.quickstart_bus_traffic.repository;

import ru.cft.shift.quickstart_bus_traffic.entity.BusModelEntity;

public interface IBusModelRepository {
  void add(BusModelEntity bus);
  BusModelEntity get(Long id);
}
