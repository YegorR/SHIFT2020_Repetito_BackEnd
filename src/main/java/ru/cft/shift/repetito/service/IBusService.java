package ru.cft.shift.repetito.service;

public interface IBusService {
  BusEntity add(BusEntity bus);
  BusEntity get(Long id);
}
