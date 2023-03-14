package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarket.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {



}
