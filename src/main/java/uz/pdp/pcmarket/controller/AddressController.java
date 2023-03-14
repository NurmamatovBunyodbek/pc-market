package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.Address;
import uz.pdp.pcmarket.payload.AddressDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Address> all() {
        List<Address> addresses = addressService.allAddressList();
        return addresses;
    }

    @GetMapping("/{id}")
    public Address getId(@PathVariable Integer id) {
        Address addressId = addressService.getAddressId(id);
        return addressId;
    }

    @PostMapping
    public Result add(@RequestBody AddressDto addressDto) {
        Result result = addressService.addAddress(addressDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
        Result result = addressService.editingAddress(id, addressDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = addressService.deleteAddress(id);
        return result;
    }

}
