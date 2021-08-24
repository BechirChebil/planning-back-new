package com.planning.planning.Controller;

import com.planning.planning.Model.CahierEtudiant;
import com.planning.planning.Model.Planning;
import com.planning.planning.service.CahierEtudiant.ICahierEtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CahierEtudiantController {

    ICahierEtudiantService cahierEtudiantService;

    public CahierEtudiantController(ICahierEtudiantService cahierEtudiantService) {
        this.cahierEtudiantService = cahierEtudiantService;
    }

    @PostMapping("/cahierEtudiant")
    public ResponseEntity<?> addCahierEtudiant(@RequestBody CahierEtudiant cahierEtudiant) {
        return new ResponseEntity<>(cahierEtudiantService.addCahierEtudiant(cahierEtudiant), HttpStatus.CREATED);
    }

    @PutMapping("/cahierEtudiant/{id}")
    public ResponseEntity<?> updateCahierEtudiant(@PathVariable Long id, @RequestBody CahierEtudiant cahierEtudiant) {
        CahierEtudiant cahierEtudiantToUpdate = cahierEtudiantService.getCahierEtudiant(id);
        if (cahierEtudiantToUpdate != null) {
            return new ResponseEntity<> (cahierEtudiantService.updateCahierEtudiant(cahierEtudiantToUpdate, cahierEtudiant), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cahierEtudiant/{id}")
    public ResponseEntity<?> getPlanning(@PathVariable Long id) {
        CahierEtudiant cahierEtudiant = cahierEtudiantService.getCahierEtudiant(id);
        HttpStatus responseStatus = cahierEtudiant != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(cahierEtudiant, responseStatus);
    }

    @GetMapping("/cahierEtudiants")
    public ResponseEntity<?> getPlannings() {
        return new ResponseEntity<>(cahierEtudiantService.getCahierEtudiants(), HttpStatus.OK);
    }
    
    @PostMapping("/cahierEtudiantByPlanning")
    public ResponseEntity<?> getCahierEtudiantByPlanning(@RequestBody Planning planning) {
        return new ResponseEntity<>(cahierEtudiantService.getCahierEtudiantByPlanning(planning), HttpStatus.OK);
    }
    
    @DeleteMapping("/cahierEtudiant/{id}")
    public ResponseEntity<?> deletePlanning(@PathVariable Long id) {
        cahierEtudiantService.deleteCahierEtudiant(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
