package com.planning.planning.Model;

import javax.persistence.*;

@Entity
public class CahierEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String introduction;
    private String sujet;
    private String indicationEtudiant;
    private String indicationsTuteur;

    @OneToOne
    //@JoinColumn(name = "id", referencedColumnName = "id")
    private Planning planning;

    public CahierEtudiant(String introduction, String sujet, String indicationEtudiant) {
        this.introduction = introduction;
        this.sujet = sujet;
        this.indicationEtudiant = indicationEtudiant;
    }

    public CahierEtudiant() {
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getIndicationEtudiant() {
        return indicationEtudiant;
    }

    public void setIndicationEtudiant(String indicationEtudiant) {
        this.indicationEtudiant = indicationEtudiant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

	public String getIndicationsTuteur() {
		return indicationsTuteur;
	}

	public void setIndicationsTuteur(String indicationsTuteur) {
		this.indicationsTuteur = indicationsTuteur;
	}

}
