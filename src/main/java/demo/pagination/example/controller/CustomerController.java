package demo.pagination.example.controller;

import demo.pagination.example.model.dto.CustomerDto;
import demo.pagination.example.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author david
 */
@RestController
@RequestMapping(CustomerController.CUSTOMER_BASE_PATH)
@Slf4j
public class CustomerController {

    public static final String CUSTOMER_BASE_PATH = "/customer";
    public static final String SEARCH_URL = "/search";

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        log.info("GET: {}", CUSTOMER_BASE_PATH);
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping(SEARCH_URL)
    public ResponseEntity<List<CustomerDto>> getCustomersByFirstName(@RequestParam String filter) {
        log.info("GET: {}{}{}", CUSTOMER_BASE_PATH, SEARCH_URL, "?filter=" + filter);
        return ResponseEntity.ok(customerService.getCustomersByFirstName(filter));
    }

}
