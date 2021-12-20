package com.ciclo4.reto3.controller;

import com.ciclo4.reto3.model.Order;
import com.ciclo4.reto3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona")String zona){
        return orderService.findByZone(zona);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> salesManExist(@PathVariable("id") int id){
        return orderService.getOrderBySalesManId(id);}

    @GetMapping("/state/{status}/{id}")
    public List<Order> salesManIdAndStatusExist(@PathVariable("id") int id, @PathVariable("status") String status){
        return orderService.getOrderBySalesManIdAndStatus(id, status);}

    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getByRegisterDayAndSalesManId(@PathVariable("registerDay")String  registerDay,@PathVariable("id") Integer id){
        return orderService.getByRegisterDayAndSalesManId(registerDay, id);}
}
