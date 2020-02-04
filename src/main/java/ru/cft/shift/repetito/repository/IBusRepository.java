package ru.cft.shift.repetito.repository;

import ru.cft.shift.repetito.entity.BusEntity;

public interface IBusRepository {
  BusEntity add(BusEntity bus);
  BusEntity get(Long id);
}
