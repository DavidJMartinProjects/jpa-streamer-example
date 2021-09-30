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

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private JpaStreamerUtil jpaStreamerUtil;

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(e -> customerMapper.toDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomersByFirstName(String filter) {
        return jpaStreamerUtil.getCustomerByFirstName(filter);
    }

}
