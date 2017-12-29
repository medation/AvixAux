package com.gi3.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kadarH
 */

@Entity
@Data
@ToString(exclude = "niveauSet")
public class Filiere {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
    private Set<Niveau> niveauSet = new HashSet<>();
}
