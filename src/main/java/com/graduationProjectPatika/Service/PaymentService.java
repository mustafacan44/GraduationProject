package com.graduationProjectPatika.Service;

import com.graduationProjectPatika.Entity.Bill;
import com.graduationProjectPatika.Entity.Payment;
import com.graduationProjectPatika.Exceptions.BalanceInsufficientException;
import com.graduationProjectPatika.IService.IPaymentService;
import com.graduationProjectPatika.Repository.BillRepository;
import com.graduationProjectPatika.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository repo;

    @Autowired
    private BillRepository billRepo;

    @Autowired
    private BillService service;

    @Override
    //The payment list is fetched.
    public List<Payment> getAll() {
        return repo.findAll();
    }

    @Override
    //A payment list is fetched by payment number.
    public Payment findById(int id){
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment is not found "));
    }

    @Override
    //Payment is created.
    public void createPayment(Payment payment) throws BalanceInsufficientException{
        List<Bill> billList = service.getBillByCustomerIdAndStatus(payment.getCustomerId(), 0);
        if (payment.getTotalAmount() >= service.getTotalAmount(payment.getCustomerId())) {
            for (Bill bill : billList) {
                bill.setStatus(1);
                billRepo.save(bill);
            }
        }else{
            throw new BalanceInsufficientException("Insufficient balance");
        }
            payment.setDate(LocalDate.now());
            repo.save(payment);
        }

}
