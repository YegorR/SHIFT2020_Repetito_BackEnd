package ru.cft.shift.quickstart_bus_traffic.repository;

import org.springframework.stereotype.Repository;
import ru.cft.shift.quickstart_bus_traffic.entity.PassengerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PassengerRepository implements IPassengerRepository {
  private final AtomicLong id = new AtomicLong();
  private final Map<Long, PassengerEntity> storage = new HashMap<>();

  @Override
  public void add(PassengerEntity passenger) {
    passenger.setId(id.incrementAndGet());
    storage.put(passenger.getId(), passenger);
  }

  @Override
  public PassengerEntity get(Long id) {
    return storage.get(id);
  }
}
