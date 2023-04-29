package org.client.ClientProfileService.repositories;

import org.client.ClientProfileService.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    Address findByIcp(String icp);
}
