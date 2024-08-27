package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
