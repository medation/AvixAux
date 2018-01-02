package com.gi3.server.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi3.server.domain.Avis;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kadarH
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true, exclude = "avisSet")
public class Enseignant extends Utilisateur {

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private Set<Avis> avisSet = new HashSet<>();

    public Set<Avis> getAvisSet() {
        return avisSet;
    }

    public void setAvisSet(Set<Avis> avisSet) {
        this.avisSet = avisSet;
    }
}
