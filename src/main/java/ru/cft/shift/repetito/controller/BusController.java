package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.BusEntity;
import ru.cft.shift.repetito.service.IBusService;

@RestController
public class BusController {
  @Autowired
  private IBusService busService;

  @RequestMapping(
      method = RequestMethod.POST,
      path = "/bus/add",
      consumes = "application/x-www-form-urlencoded",
      produces = "application/json"
  ) public BusEntity add(@RequestParam(name = "number") String number) {
    BusEntity bus = new BusEntity();
    bus.setNumber(number);
fd
    return busService.add(bus);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/bus/{id}", produces = "application/json")
  public BusEntity get(@PathVariable(name = "id") Long id) {
    return busService.get(id);
  }
}
