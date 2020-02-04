package ru.cft.shift.repetito.repository;

import ru.cft.shift.repetito.entity.PassengerEntity;

public interface IPassengerRepository {
  void add(PassengerEntity bus);
  PassengerEntity get(Long id);
}
