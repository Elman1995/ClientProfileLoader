package org.client.ClientProfileLoader.repositories;

import org.client.ClientProfileLoader.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, String> {
    Individual findByIcp(String icp);
}
