package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarket.entity.Component;

public interface ComponentRepo extends JpaRepository<Component,Integer> {


}
