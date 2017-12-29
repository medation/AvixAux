package com.gi3.server.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi3.server.domain.users.Enseignant;
import com.gi3.server.domain.users.Etudiant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kadarH
 */
@Entity
@Data
@ToString(exclude = {"etudiantSet", "enseignant"})
@EqualsAndHashCode(exclude = {"etudiantSet", "enseignant"})
public class Avis {

    @Id
    @GeneratedValue
    private Long id;
    private String message;

    @ManyToOne
    private Enseignant enseignant;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "etudiant_avis", joinColumns = @JoinColumn(name = "etudiant_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "avis_id", referencedColumnName = "id"))
    private Set<Etudiant> etudiantSet = new HashSet<>();

    @Lob
    private byte[] doc;

    private LocalDateTime date;

    public void addToSet(Etudiant etudiant) {
        etudiantSet.add(etudiant);
    }

    public void removeFromSet(Etudiant etudiant) {
        etudiantSet.remove(etudiant);
    }

}
