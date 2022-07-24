package com.graduationProjectPatika.Controller;

import com.graduationProjectPatika.Entity.Customer;
import com.graduationProjectPatika.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCustomer() {
        try {
            return ResponseEntity.ok(service.getAll());

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        service.createCustomer(customer);
        return ResponseEntity.ok("Customer created");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        try {
            service.deleteCustomer(id);
            return ResponseEntity.ok("Customer deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Customer is not deleted");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@RequestParam(required = false) String name, @RequestParam(required = false) String surname,
                                            @PathVariable("id") int id) {
        try {
            service.updateCustomer(name, surname, id);
            return ResponseEntity.ok("Customer updated");

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
