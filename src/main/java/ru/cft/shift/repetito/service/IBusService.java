package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.BusEntity;

public interface IBusService {
  BusEntity add(BusEntity bus);
  BusEntity get(Long id);
}
