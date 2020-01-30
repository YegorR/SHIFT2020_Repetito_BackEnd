package ru.cft.shift.quickstart_bus_traffic.repository;

import org.springframework.stereotype.Repository;
import ru.cft.shift.quickstart_bus_traffic.entity.BusModelEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BusModelRepository implements IBusModelRepository {
  private final AtomicLong id = new AtomicLong();
  private final Map<Long, BusModelEntity> storage = new HashMap<>();

  @Override
  public void add(BusModelEntity busModel) {
    busModel.setId(id.incrementAndGet());
    storage.put(busModel.getId(), busModel);
  }

  @Override
  public BusModelEntity get(Long id) {
    return storage.get(id);
  }
}
