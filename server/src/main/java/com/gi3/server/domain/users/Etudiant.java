package com.gi3.server.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi3.server.domain.Avis;
import com.gi3.server.domain.Groupe;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "etudiant_avis", joinColumns = @JoinColumn(name = "utilisateur_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "avis_id", referencedColumnName = "id"))
    private Set<Avis> avisSet = new HashSet<>();
}
