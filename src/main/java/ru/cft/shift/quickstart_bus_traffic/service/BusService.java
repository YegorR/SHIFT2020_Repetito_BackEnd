package ru.cft.shift.quickstart_bus_traffic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.quickstart_bus_traffic.entity.BusEntity;
import ru.cft.shift.quickstart_bus_traffic.repository.IBusRepository;

@Service
public class BusService implements IBusService {

  @Autowired
  private IBusRepository busRepository;

  @Override
  public BusEntity add(BusEntity bus) {
    return busRepository.add(bus);
  }

  @Override
  public BusEntity get(Long id) {
    return busRepository.get(id);
  }
}
