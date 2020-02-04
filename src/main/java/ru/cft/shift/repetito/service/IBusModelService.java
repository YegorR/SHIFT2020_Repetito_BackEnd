package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.BusModelEntity;

public interface IBusModelService {
  void add(BusModelEntity bus);
  BusModelEntity get(Long id);
}
