package com.gi3.server.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi3.server.domain.Avis;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kadarH
 */
@Entity
@Data
public class Enseignant extends Utilisateur {

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private Set<Avis> avisSet = new HashSet<>();
}
