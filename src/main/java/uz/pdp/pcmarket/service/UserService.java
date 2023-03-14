package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarket.entity.Address;
import uz.pdp.pcmarket.entity.User;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.payload.UserDto;
import uz.pdp.pcmarket.repository.AddressRepo;
import uz.pdp.pcmarket.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    AddressRepo addressRepo;

    public List<User> allUserList() {
        List<User> userList = userRepo.findAll();
        return userList;
    }

    public User getIdUser(Integer id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.get();
    }

    public Result addUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        Optional<Address> optionalAddress = addressRepo.findById(userDto.getAddress());
        user.setAddress(optionalAddress.get());
        user.setBalance(userDto.getBalance());
        userRepo.save(user);
        return new Result("User added", true);
    }

    public Result editingUser(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setBalance(userDto.getBalance());
            Optional<Address> optionalAddress = addressRepo.findById(userDto.getAddress());
            user.setAddress(optionalAddress.get());
            return new Result("Editing User", true);
        }
        return new Result("User not found", false);
    }

    public Result deletedId(Integer id) {
        userRepo.deleteById(id);
        return new Result("User deleted", true);
    }

}
