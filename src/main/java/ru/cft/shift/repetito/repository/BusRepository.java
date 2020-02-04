package ru.cft.shift.repetito.repository;

import org.springframework.stereotype.Repository;
import ru.cft.shift.repetito.entity.BusEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BusRepository implements IBusRepository {
  private final AtomicLong id = new AtomicLong();
  private final Map<Long, BusEntity> storage = new HashMap<>();

  @Override
  public BusEntity add(BusEntity bus) {
    bus.setId(id.incrementAndGet());
    storage.put(bus.getId(), bus);
    return bus;
  }

  @Override
  public BusEntity get(Long id) {
    return storage.get(id);
  }
}
