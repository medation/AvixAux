package com.gi3.server.repo.users;

import com.gi3.server.domain.users.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {

    @Query("select e from Enseignant e where e.userName=?0")
    Enseignant findByUserName(String username);
}
