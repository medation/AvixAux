package com.gi3.server.controller;

import com.gi3.server.domain.users.Utilisateur;
import com.gi3.server.dto.LoginDTO;
import com.gi3.server.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

/**
 * @author kadarH
 */

@RestController
@RequestMapping("")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    /**
     * @param id of the user to update
     * @return
     */
    @PutMapping("/user/{id}/put")
    public Utilisateur changeProfile(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
        return utilisateurService.updateProfile(utilisateur, id);
    }

    @PostMapping("/login")
    public Utilisateur login(@RequestBody LoginDTO loginDTO) {
        return utilisateurService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }
}
