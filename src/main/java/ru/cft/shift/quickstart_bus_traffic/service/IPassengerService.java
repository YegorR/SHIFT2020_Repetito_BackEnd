package ru.cft.shift.quickstart_bus_traffic.service;

import ru.cft.shift.quickstart_bus_traffic.entity.BusEntity;
import ru.cft.shift.quickstart_bus_traffic.entity.PassengerEntity;

public interface IPassengerService {
  void add(PassengerEntity bus);
  PassengerEntity get(Long id);
}
