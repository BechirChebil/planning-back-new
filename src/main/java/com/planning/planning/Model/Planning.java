package com.planning.planning.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String sujet;
    private String introduction;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    //@JsonIgnore
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "planning")
    @JsonManagedReference
    //@JsonIgnoreProperties({"phases", "planning"})
    //@JsonProperty("Seances")
    private List<Seance> seances;

    public Planning() {
    }

    public Planning(Long id, String titre, Date startTime, List<Seance> seances) {
        this.id = id;
        this.titre = titre;
        this.startTime = startTime;
        this.seances = seances;
    }

//    public Planning(String titre, Date startTime) {
//        this.titre = titre;
//        this.startTime = startTime;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String sujet) {
        this.titre = sujet;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
