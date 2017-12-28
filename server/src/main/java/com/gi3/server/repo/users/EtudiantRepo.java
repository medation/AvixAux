package com.gi3.server.repo.users;

import com.gi3.server.domain.users.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {

}
