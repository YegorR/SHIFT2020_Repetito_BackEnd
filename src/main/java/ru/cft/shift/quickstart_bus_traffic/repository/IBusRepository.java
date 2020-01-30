package ru.cft.shift.quickstart_bus_traffic.repository;

import ru.cft.shift.quickstart_bus_traffic.entity.BusEntity;

public interface IBusRepository {
  BusEntity add(BusEntity bus);
  BusEntity get(Long id);
}
