package com.graduationProjectPatika.IService;

import com.graduationProjectPatika.Entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAll();

    void createCustomer(Customer customer);

    Customer findById(int id);

    void deleteCustomer(int id);

    void updateCustomer(String name, String surname,int id);

}
