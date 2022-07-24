package com.graduationProjectPatika.Service;

import com.graduationProjectPatika.Entity.Customer;
import com.graduationProjectPatika.IService.ICustomerService;
import com.graduationProjectPatika.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository repo;


    @Override
    //The customer list is fetched.
    public List<Customer> getAll() {
        return repo.findAll();
    }

    @Override
    //Customer is created.
    public void createCustomer(Customer customer) {
        repo.save(customer);
    }

    @Override
    //The customer list is returned based on the customer number.
    public Customer findById(int id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Override
    //The customer is deleted based on the customer number.
    public void deleteCustomer(int id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional
    //The customer is updated based on the customer number.
    public void updateCustomer(String name, String surname, int id) {
        Customer customerToUpdate = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        if (Objects.nonNull(name) && name.length() > 0 && !customerToUpdate.getName().equals(name)) {
            customerToUpdate.setName(name);
        }

        if (Objects.nonNull(surname) && surname.length() > 0 && !customerToUpdate.getSurname().equals(surname)) {
            customerToUpdate.setSurname(surname);
        }
    }
}
