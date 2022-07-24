package com.graduationProjectPatika.Service;

import com.graduationProjectPatika.Entity.Bill;
import com.graduationProjectPatika.IService.IBillService;
import com.graduationProjectPatika.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BillService implements IBillService {

    @Autowired
    private BillRepository repo;

    @Autowired
    private CustomerService customerService;

    @Override
    //Total invoice debt is calculated.
    public int getTotalAmount(int customerId) {
        int total = 0;
        List<Bill> billList = repo.getBillByCustomerIdAndStatus(customerId,0);
        for (Bill bill : billList) {
            total += bill.getBillAmount();
        }
        return total;
    }

    @Override
    //The list of invoices is returned by customer number.
    public List<Bill> getBillByCustomerIdAndStatus(int customerId, int status) {
        return repo.getBillByCustomerIdAndStatus(customerId,status);
    }

    @Override
    //Invoice is created.
    public void createBill(Bill bill) {
        repo.save(bill);
    }


    @Override
    //The invoice is deleted based on the invoice number.
    public void delete(int id) {
        repo.deleteById(id);

    }

    @Override
    //An invoice list is returned based on the invoice number.
    public Bill findByBillId(int id) {
        return repo.findById(id).orElseThrow(()-> new EntityNotFoundException("Bill is not found"));
    }

    @Override
    //The whole invoice list is retrieved.
    public List<Bill> getAll() {
        return repo.findAll();
    }


}
