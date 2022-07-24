package com.graduationProjectPatika.Controller;

import com.graduationProjectPatika.Entity.Bill;
import com.graduationProjectPatika.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("bill")
public class BillController {

    @Autowired
    private BillService service;

    @GetMapping("/total-amount/{customerId}")
    public ResponseEntity<?> getTotalAmount(@PathVariable int customerId) {
        try {
            if (service.getTotalAmount(customerId) == 0) {
                return ResponseEntity.badRequest().body("You have no debt");
            } else{
                return ResponseEntity.ok(service.getTotalAmount(customerId));
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("bill-list/{customerId}")
    public ResponseEntity<?> getAllList(@PathVariable int customerId) {
        if (service.getTotalAmount(customerId) == 0) {
            return ResponseEntity.badRequest().body("You don't have any unpaid invoices");
        }else{
            return ResponseEntity.ok(service.getBillByCustomerIdAndStatus(customerId, 0));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try {
            if(service.findByBillId(id).getStatus()==1){
                return ResponseEntity.ok("You don't have any unpaid invoices");
            }else{
                return ResponseEntity.ok(service.findByBillId(id));
            }

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllBill(){
        try {
            return ResponseEntity.ok(service.getAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBill(@RequestBody Bill bill) {
        service.createBill(bill);
        return ResponseEntity.ok("Bill created");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Bill deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bill is not deleted ");
        }
    }

}
