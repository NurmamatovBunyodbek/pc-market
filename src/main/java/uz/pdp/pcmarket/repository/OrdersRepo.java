package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarket.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders,Integer> {


}
