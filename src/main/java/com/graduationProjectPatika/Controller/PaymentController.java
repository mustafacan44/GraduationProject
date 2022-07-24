package com.graduationProjectPatika.Controller;

import com.graduationProjectPatika.Entity.Bill;
import com.graduationProjectPatika.Entity.Payment;
import com.graduationProjectPatika.Exceptions.BalanceInsufficientException;
import com.graduationProjectPatika.Service.BillService;
import com.graduationProjectPatika.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Autowired
    private BillService billService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
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
    public ResponseEntity<String> createPayment(@RequestBody Payment payment) {
        List<Bill> billList = billService.getBillByCustomerIdAndStatus(payment.getCustomerId(), 0);
        if (billList.size() == 0) {
            return ResponseEntity.badRequest().body("You don't have any unpaid invoices");
        }
        try {
            service.createPayment(payment);
            return ResponseEntity.ok("Payment created");
        }catch (BalanceInsufficientException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }






}
