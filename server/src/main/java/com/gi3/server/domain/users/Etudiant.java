package com.gi3.server.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi3.server.domain.Avis;
import com.gi3.server.domain.Groupe;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author kadarH
 */

@Entity
@Data
@ToString(exclude = "groupe")
@EqualsAndHashCode(callSuper = true, exclude = "groupe")
public class Etudiant extends Utilisateur {

    @JsonIgnore
    @ManyToOne
    private Groupe groupe;

    @ManyToMany(mappedBy = "etudiantSet")
    @JsonIgnore
    private Set<Avis> avisSet=new HashSet<>();

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Set<Avis> getAvisSet() {
        return avisSet;
    }

    public void setAvisSet(Set<Avis> avisSet) {
        this.avisSet = avisSet;
    }
}
