package com.gi3.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi3.server.domain.users.Etudiant;
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
@ToString(exclude = {"etudiantSet", "niveau"})
@EqualsAndHashCode(exclude = {"etudiantSet", "niveau"})
public class Groupe {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiantSet = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    private Niveau niveau;

}
