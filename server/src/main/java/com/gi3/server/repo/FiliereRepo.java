package com.gi3.server.repo;

import com.gi3.server.domain.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepo extends JpaRepository<Filiere, Long> {

    @Query("select f from Filiere f where f.nom=?0")
    Filiere findByNom(String nom);

}
