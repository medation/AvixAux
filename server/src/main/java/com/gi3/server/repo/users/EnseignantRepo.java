package com.gi3.server.repo.users;

import com.gi3.server.domain.users.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {

    Enseignant findByUserNameAndPassword(String username, String password);

    Enseignant findByUserName(String username_professeur);
}
