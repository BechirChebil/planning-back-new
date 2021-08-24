package com.planning.planning.Controller;

import com.planning.planning.Model.CahierTuteur;
import com.planning.planning.service.CahierTuteur.ICahierTuteurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CahierTuteurController {

    ICahierTuteurService cahierTuteurService;

    public CahierTuteurController(ICahierTuteurService cahierTuteurService) {
        this.cahierTuteurService = cahierTuteurService;
    }

    @PostMapping("/cahierTuteur")
    public ResponseEntity<?> addCahierEtudiant(@RequestBody CahierTuteur cahierTuteur) {
        return new ResponseEntity<>(cahierTuteurService.addCahierTuteur(cahierTuteur), HttpStatus.CREATED);
    }

    @PutMapping("/cahierTuteur/{id}")
    public ResponseEntity<?> updateCahierEtudiant(@PathVariable Long id, @RequestBody CahierTuteur cahierTuteur) {
        CahierTuteur cahierTuteurToUpdate = cahierTuteurService.getCahierTuteur(id);
        if (cahierTuteurToUpdate != null) {
            return new ResponseEntity<> (cahierTuteurService.updateCahierTuteur(cahierTuteurToUpdate, cahierTuteur), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cahierTuteur/{id}")
    public ResponseEntity<?> getPlanning(@PathVariable Long id) {
        CahierTuteur cahierTuteur = cahierTuteurService.getCahierTuteur(id);
        HttpStatus responseStatus = cahierTuteur != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(cahierTuteur, responseStatus);
    }

    @GetMapping("/cahierTuteurs")
    public ResponseEntity<?> getPlannings() {
        return new ResponseEntity<>(cahierTuteurService.getCahierTuteurs(), HttpStatus.OK);
    }

    @DeleteMapping("/cahierTuteur/{id}")
    public ResponseEntity<?> deletePlanning(@PathVariable Long id) {
        cahierTuteurService.deleteCahierTuteur(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
