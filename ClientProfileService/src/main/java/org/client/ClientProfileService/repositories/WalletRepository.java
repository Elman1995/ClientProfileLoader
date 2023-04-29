package org.client.ClientProfileService.repositories;

import org.client.ClientProfileService.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
    Wallet findByIcp(String icp);
}
