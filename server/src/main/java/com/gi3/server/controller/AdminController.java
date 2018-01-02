package com.gi3.server.controller;

import com.gi3.server.domain.Avis;
import com.gi3.server.domain.users.Utilisateur;
import com.gi3.server.dto.AvisDTO;
import com.gi3.server.dto.UtilisateurDTO;
import com.gi3.server.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author kadarH
 */

@RestController
@RequestMapping("/admin")
public class AdminController {


    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * To add a user by Admin
     *
     * @param utilisateur Admin or enseignant or etudiant
     * @return
     */
    @PostMapping("/add")
    public UtilisateurDTO addUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        return adminService.add(utilisateurDTO);
    }

    /**
     * @return list of all users
     */
    @GetMapping("/users")
    public List<Utilisateur> usersList() {
        return adminService.listUsers();
    }

    /**
     * @param id : the id of the user to delete
     */
    @DeleteMapping("/{user}/{id}/delete")
    public void deleteUser(@PathVariable Long id, @PathVariable String user) {
        adminService.deleteUser(id, user);
    }

    /**
     * @return list of all Avis
     */
    @GetMapping("/avis")
    public Set<AvisDTO> avisList() {
        return adminService.listAvix();
    }

    /**
     * @param id the id of the Avis to delete
     */
    @DeleteMapping("/avis/{id}/delete")
    public void deleteAvis(@PathVariable Long id) {
        adminService.deleteAvix(id);
    }

}
