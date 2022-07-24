package com.graduationProjectPatika.IService;

import com.graduationProjectPatika.Entity.Bill;

import java.util.List;

public interface IBillService {

    int getTotalAmount(int customerId);

    List<Bill> getBillByCustomerIdAndStatus(int customerId,int status);

    void createBill(Bill bill);

    void delete(int id);

    Bill findByBillId(int id);

    List<Bill> getAll();

}
