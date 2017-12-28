package com.gi3.server.repo;

import com.gi3.server.domain.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepo extends JpaRepository<Niveau, Long> {

    @Query("select n from Niveau n where n.nom=?0")
    Niveau findByNom(String nom);

}
