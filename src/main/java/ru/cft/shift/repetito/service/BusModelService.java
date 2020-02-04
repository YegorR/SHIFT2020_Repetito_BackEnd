package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.BusModelEntity;
import ru.cft.shift.repetito.repository.IBusModelRepository;

@Service
public class BusModelService implements IBusModelService {

  @Autowired
  private IBusModelRepository busModelRepository;

  @Override
  public void add(BusModelEntity bus) {
    busModelRepository.add(bus);
  }

  @Override
  public BusModelEntity get(Long id) {
    return busModelRepository.get(id);
  }
}
