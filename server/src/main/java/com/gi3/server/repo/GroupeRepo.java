package com.gi3.server.repo;

import com.gi3.server.domain.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepo extends JpaRepository<Groupe, Long> {

    Groupe findByNom(String nom);

}
