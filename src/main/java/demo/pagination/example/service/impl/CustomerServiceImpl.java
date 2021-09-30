package demo.pagination.example.service.impl;

import demo.pagination.example.model.CustomerDto;
import demo.pagination.example.repository.CustomerRepository;
import demo.pagination.example.repository.jpastreamer.JpaStreamerUtil;
import demo.pagination.example.repository.mapper.CustomerMapper;
import demo.pagination.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author david
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final JpaStreamerUtil jpaStreamerUtil;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper, JpaStreamerUtil jpaStreamerUtil) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.jpaStreamerUtil = jpaStreamerUtil;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomersByFirstName(String filter) {
        return jpaStreamerUtil.getCustomerByFirstName(filter);
    }

}
