package me.wonwoo.customer.repository;

import me.wonwoo.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoo on 2016. 5. 4..
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
