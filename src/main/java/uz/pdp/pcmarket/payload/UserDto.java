package uz.pdp.pcmarket.payload;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.pcmarket.entity.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;
    private String email;
    private Double balance;
    private String phoneNumber;
    private Integer address;
}
