package com.gi3.server.domain.users;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author kadarH
 */

@MappedSuperclass
@Data
public class Utilisateur {

    @Id
    @GeneratedValue
    private Long id;
    private String prenom;
    private String nom;
    private String userName;
    private String password;
    private String role;

}
