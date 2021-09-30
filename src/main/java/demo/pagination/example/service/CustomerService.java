package demo.pagination.example.service;

import demo.pagination.example.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author david
 */
@Service
public interface CustomerService {
    List<CustomerDto> getCustomers();
    List<CustomerDto> getCustomersByFirstName(String filter);
}
