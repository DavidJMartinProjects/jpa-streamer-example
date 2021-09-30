package demo.pagination.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author david
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private long id;
    private String firstName;
    private String lastName;

    private String address;
    private String city;
    private String country;

    private String email;
    private String image;

}
