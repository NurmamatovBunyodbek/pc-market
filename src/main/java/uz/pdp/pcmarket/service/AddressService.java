package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarket.entity.Address;
import uz.pdp.pcmarket.payload.AddressDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.repository.AddressRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public List<Address> allAddressList() {
        List<Address> addressList = addressRepo.findAll();
        return addressList;
    }

    public Address getAddressId(Integer id) {
        Optional<Address> optionalAddress = addressRepo.findById(id);
        return optionalAddress.get();
    }

    public Result addAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setDistrict(addressDto.getDistrict());
        address.setStreet(addressDto.getStreet());
        address.setHomeNumber(addressDto.getHomeNumber());
        addressRepo.save(address);
        return new Result("Address added", true);
    }

    public Result editingAddress(Integer id, AddressDto addressDto) {
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isPresent()) {
            Address address = addressOptional.get();
            address.setCity(addressDto.getCity());
            address.setDistrict(addressDto.getStreet());
            address.setStreet(addressDto.getStreet());
            address.setHomeNumber(addressDto.getHomeNumber());
            addressRepo.save(address);
            return new Result("edit Address", true);
        }
        return new Result("Address not found", false);
    }

    public Result deleteAddress(Integer id) {
        addressRepo.deleteById(id);
        return new Result("Address deleted", true);
    }


}
