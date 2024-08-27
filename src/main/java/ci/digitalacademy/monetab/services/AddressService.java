package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.NoteFile;
import ci.digitalacademy.monetab.models.User;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address save(Address address);

    Address update(Address address);

    Optional<Address> findOne(Long id_address);

    List<Address> findAll();

    void delete(Long id_address);
}
