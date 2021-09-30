package demo.pagination.example.jpastreamer;

import com.speedment.jpastreamer.application.JPAStreamer;
import demo.pagination.example.model.CustomerDto;
import demo.pagination.example.repository.entity.CustomerEntity;
import demo.pagination.example.repository.entity.CustomerEntity$;
import demo.pagination.example.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author david
 */
@Component
public class JpaStreamerUtil {

    private final JPAStreamer jpaStreamer;
    private final CustomerMapper customerMapper;

    @Autowired
    public JpaStreamerUtil(JPAStreamer jpaStreamer, CustomerMapper customerMapper) {
        this.jpaStreamer = jpaStreamer;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDto> getCustomerByFirstName(String filter) {
        return jpaStreamer.stream(CustomerEntity.class)
            .filter(CustomerEntity$.firstName.startsWithIgnoreCase(filter))
            .map(customerMapper::toDto)
            .collect(Collectors.toList());
    }

}
