package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.PassengerEntity;

public interface IPassengerService {
  void add(PassengerEntity bus);
  PassengerEntity get(Long id);
}
