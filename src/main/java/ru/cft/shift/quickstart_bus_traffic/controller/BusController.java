package ru.cft.shift.quickstart_bus_traffic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.quickstart_bus_traffic.entity.BusEntity;
import ru.cft.shift.quickstart_bus_traffic.entity.BusModelEntity;
import ru.cft.shift.quickstart_bus_traffic.service.IBusService;

@RestController
public class BusController {
  @Autowired
  private IBusService busService;

  @RequestMapping(
      method = RequestMethod.POST,
      path = "/bus/add",
      consumes = "application/x-www-form-urlencoded",
      produces = "application/json"
  ) public BusEntity add(
      @RequestParam(name = "number") String number,
      @RequestParam(name = "busModel") BusModelEntity busModel
  ) {
    BusEntity bus = new BusEntity();
    bus.setNumber(number);
    bus.setModel(busModel);

    return busService.add(bus);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/bus/{id}", produces = "application/json")
  public BusEntity get(@PathVariable(name = "id") Long id) {
    return busService.get(id);
  }
}
