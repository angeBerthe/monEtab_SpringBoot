package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.AddressRepository;
import ci.digitalacademy.monetab.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;


    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        Optional<Address> optionalAddress = findOne(address.getId_addess());
        if (optionalAddress.isPresent()){
            Address addressToUpdate = optionalAddress.get();
            addressToUpdate.setCity(address.getCity());
            addressToUpdate.setCompagny(address.getCompagny());
            addressToUpdate.setStreet(address.getStreet());
            return save(addressToUpdate);
        }else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Optional<Address> findOne(Long id_address) {
        return addressRepository.findById(id_address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long id_address) {
        addressRepository.deleteById(id_address);
    }
}
