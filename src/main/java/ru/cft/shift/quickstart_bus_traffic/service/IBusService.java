package ru.cft.shift.quickstart_bus_traffic.service;

import ru.cft.shift.quickstart_bus_traffic.entity.BusEntity;

public interface IBusService {
  BusEntity add(BusEntity bus);
  BusEntity get(Long id);
}
