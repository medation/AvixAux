package com.gi3.server.repo;

import com.gi3.server.domain.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepo extends JpaRepository<Avis, Long> {

}
