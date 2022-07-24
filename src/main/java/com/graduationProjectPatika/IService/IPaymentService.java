package com.graduationProjectPatika.IService;

import com.graduationProjectPatika.Entity.Payment;
import com.graduationProjectPatika.Exceptions.BalanceInsufficientException;

import java.util.List;

public interface IPaymentService {

    List<Payment> getAll();

    void createPayment(Payment payment)throws BalanceInsufficientException;

    Payment findById(int id);

}
