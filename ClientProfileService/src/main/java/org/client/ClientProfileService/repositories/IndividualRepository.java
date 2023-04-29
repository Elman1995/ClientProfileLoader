package org.client.ClientProfileService.repositories;

import org.client.ClientProfileService.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, String> {
    Individual findByIcp(String icp);

	Individual findByUuid(String uuid);

    @Query("SELECT i.uuid, i.icp, i.fullname, i.wallets " +
            "FROM Individual i " +
            "INNER JOIN i.contacts c " +
            "INNER JOIN c.phoneNumbers p " +
            "WHERE p.value = 'xxx'")
    Individual findByContacts(@Param("value") String phoneNumber);
}
