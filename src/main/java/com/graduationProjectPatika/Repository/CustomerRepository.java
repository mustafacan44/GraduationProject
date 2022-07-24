package com.graduationProjectPatika.Repository;

import com.graduationProjectPatika.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /*
    With the repository, add, delete and update operations are managed.
    In JpaRepository, both the table and the primary key must be specified.
     */
}
