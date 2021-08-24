package com.planning.planning.Model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String rendu;
    private String discription;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date endTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    @JoinColumn(name="seance_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore//Properties({"hibernateLazyInitializer", "handler"})
    //@JsonIgnoreProperties({"Phases"})rfrfr
    //@JsonProperty("seance")
    private Seance seance;


    public Phase() {
    }

//    public Phase(String titre, String rendu, String discription, Date startTime, Date endTime) {
//        this.titre = titre;
//        this.rendu = rendu;
//        this.discription = discription;
//        this.startTime = startTime;
//        this.endTime = endTime;
//
//    }



    public Phase(Long id, String titre, String rendu, String discription, Date startTime, Date endTime, Seance seance) {
        this.id = id;
        this.titre = titre;
        this.rendu = rendu;
        this.discription = discription;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seance = seance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getRendu() {
        return rendu;
    }

    public void setRendu(String rendu) {
        this.rendu = rendu;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }


}
