package ru.cft.shift.repetito.service;

public interface IPassengerService {
  void add(PassengerEntity bus);
  PassengerEntity get(Long id);
}
