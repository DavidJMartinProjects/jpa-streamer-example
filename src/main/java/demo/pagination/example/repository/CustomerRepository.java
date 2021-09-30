package demo.pagination.example.repository;

import demo.pagination.example.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author david
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
