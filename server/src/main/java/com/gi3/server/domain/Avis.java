package com.gi3.server.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi3.server.domain.users.Enseignant;
import com.gi3.server.domain.users.Etudiant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kadarH
 */
@Entity
@ToString(exclude = {"etudiantSet", "enseignant"})
@EqualsAndHashCode(exclude = {"etudiantSet", "enseignant"})
public class Avis {

    @Id
    @GeneratedValue
    private Long id;
    private String message;
    private String filiere;
    private String niveau;
    private String groupe;

    @ManyToOne
    private Enseignant enseignant;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "etudiant_avis", joinColumns = @JoinColumn(name = "etudiant_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "avis_id", referencedColumnName = "id"))
    private Set<Etudiant> etudiantSet = new HashSet<>();

    private LocalDateTime date;

    public void addToSet(Etudiant etudiant) {
        etudiantSet.add(etudiant);
    }

    public void removeFromSet(Etudiant etudiant) {
        etudiantSet.remove(etudiant);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Set<Etudiant> getEtudiantSet() {
        return etudiantSet;
    }

    public void setEtudiantSet(Set<Etudiant> etudiantSet) {
        this.etudiantSet = etudiantSet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}
