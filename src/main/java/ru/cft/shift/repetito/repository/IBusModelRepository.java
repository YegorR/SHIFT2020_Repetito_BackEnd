package ru.cft.shift.repetito.repository;

import ru.cft.shift.repetito.entity.BusModelEntity;

public interface IBusModelRepository {
  void add(BusModelEntity bus);
  BusModelEntity get(Long id);
}
