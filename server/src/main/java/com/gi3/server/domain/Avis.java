package com.gi3.server.domain;


import com.gi3.server.domain.users.Enseignant;
import com.gi3.server.domain.users.Etudiant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @ManyToMany(mappedBy = "avisSet")
    private Set<Etudiant> etudiantSet;
    private byte[] doc;
    private LocalDateTime date;

}
