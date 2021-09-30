package demo.pagination.example.repository.mapper;

import demo.pagination.example.model.CustomerDto;
import demo.pagination.example.repository.entity.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author david
 */
@Component
@Slf4j
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;

    private CustomerMapper() {}

    public CustomerDto toDto(CustomerEntity customerEntity) {
        log.debug("mapping customer entity with id: {} to dto.", customerEntity.getId());
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    public CustomerEntity toEntity(CustomerDto customerDto) {
        log.debug("mapping customer dto with to entity.");
        return modelMapper.map(customerDto, CustomerEntity.class);
    }

}
