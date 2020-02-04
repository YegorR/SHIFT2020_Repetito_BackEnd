package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService implements IPassengerService {

  @Autowired
  private IPassengerRepository passengerRepository;

  @Override
  public void add(PassengerEntity bus) {
    passengerRepository.add(bus);
  }

  @Override
  public PassengerEntity get(Long id) {
    return passengerRepository.get(id);
  }
}
