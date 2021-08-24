package com.planning.planning.Model;

import javax.persistence.*;

@Entity
public class CahierTuteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String indicationsTuteur;

    @OneToOne
    //@JoinColumn(name = "id", referencedColumnName = "id")
    private CahierEtudiant cahierEtudiant;




    public CahierTuteur() {
    }

    public CahierTuteur(String indicationsTuteur) {
        this.indicationsTuteur = indicationsTuteur;
    }

    public CahierEtudiant getCahierEtudiant() {
        return cahierEtudiant;
    }

    public void setCahierEtudiant(CahierEtudiant cahierEtudiant) {
        this.cahierEtudiant = cahierEtudiant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndicationsTuteur() {
        return indicationsTuteur;
    }

    public void setIndicationsTuteur(String indicationsTuteur) {
        this.indicationsTuteur = indicationsTuteur;
    }
}
