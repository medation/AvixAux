package com.gi3.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@ToString(exclude = {"groupeSet", "filiere"})
@EqualsAndHashCode(exclude = {"groupeSet", "filiere"})
public class Niveau {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "niveau", cascade = CascadeType.ALL)
    private Set<Groupe> groupeSet = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    private Filiere filiere;
}
