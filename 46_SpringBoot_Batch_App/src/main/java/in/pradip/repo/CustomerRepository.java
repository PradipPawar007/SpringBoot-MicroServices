package in.pradip.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pradip.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
