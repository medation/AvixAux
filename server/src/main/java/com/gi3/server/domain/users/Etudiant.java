package com.gi3.server.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi3.server.domain.Groupe;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
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

}
