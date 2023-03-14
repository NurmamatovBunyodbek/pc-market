package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarket.entity.Address;

public interface AddressRepo extends JpaRepository<Address,Integer> {


}
