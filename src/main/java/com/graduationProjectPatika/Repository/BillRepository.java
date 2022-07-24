package com.graduationProjectPatika.Repository;

import com.graduationProjectPatika.Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {

    List<Bill> getBillByCustomerIdAndStatus(int customerId, int status);
}
