package com.gi3.server.controller;

import com.gi3.server.domain.users.Utilisateur;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kadarH
 */

@RestController
@RequestMapping("/user")
public class UtilisateurController {

    /**
     * @param id of the user to update
     * @return
     */
    @PutMapping("/{id}/put")
    public Utilisateur changeProfile(@PathVariable Long id) {
        return null;
    }
}
