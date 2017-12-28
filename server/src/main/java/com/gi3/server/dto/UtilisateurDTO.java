package com.gi3.server.dto;

import lombok.Data;

/**
 * @author kadarH
 */

@Data
public class UtilisateurDTO {

    private String prenom;
    private String nom;
    private String userName;
    private String password;
    private String role;
    private String groupe;

}
