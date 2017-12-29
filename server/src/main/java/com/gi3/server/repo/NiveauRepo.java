package com.gi3.server.repo;

import com.gi3.server.domain.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepo extends JpaRepository<Niveau, Long> {

    Niveau findByNom(String nom);

}
