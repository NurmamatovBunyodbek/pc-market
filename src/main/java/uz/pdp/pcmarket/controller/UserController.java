package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;
import uz.pdp.pcmarket.entity.User;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.payload.UserDto;
import uz.pdp.pcmarket.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> all() {
        List<User> allUserList = userService.allUserList();
        return allUserList;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        User idUser = userService.getIdUser(id);
        return idUser;
    }

    @PostMapping
    public Result add(@RequestBody UserDto userDto) {
        Result result = userService.addUser(userDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody UserDto userDto) {
        Result result = userService.editingUser(id, userDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = userService.deletedId(id);
        return result;
    }

}
