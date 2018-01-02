package com.gi3.server.repo;

import com.gi3.server.domain.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AvisRepo extends JpaRepository<Avis, Long> {
}
