package com.planning.planning.Controller;

import com.planning.planning.Model.Phase;
import com.planning.planning.service.Phase.IPhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class PhaseController {
    @Autowired
    IPhaseService phaseService;
   // @CrossOrigin(origins = "http://localhost:3000/")


    public PhaseController(IPhaseService phaseService) {
        this.phaseService = phaseService;
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }

    @PostMapping("/phase")
    public ResponseEntity<Phase> addPhase(@RequestBody Phase phase) {
        phase=phaseService.addPhase(phase);
        return new ResponseEntity<>(phase, HttpStatus.CREATED);
    }

    @PutMapping("/phase/{id}")
    public ResponseEntity<?> updatePhase(@PathVariable Long id, @RequestBody Phase phase) {
        Phase phaseToUpdate = phaseService.getPhase(id);
        if (phaseToUpdate != null) {
            return new ResponseEntity<> (phaseService.updatePhase(phaseToUpdate, phase), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/phase/{id}")
    public ResponseEntity<?> getPhase(@PathVariable Long id) {
        Phase phase = phaseService.getPhase(id);
        HttpStatus responseStatus = phase != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(phase, responseStatus);
    }

//    @GetMapping("/phases/")
//    public ResponseEntity<?> getPhases() {
//        return new ResponseEntity<>(phaseService.getPhases(), HttpStatus.OK);
//    }
//
//    public List<Phase> getPhases();

    @GetMapping("/phases")
    @ResponseBody
        public List<Phase> getPhases() {
        List<Phase> list = phaseService.getPhases();
        return list;
    }

//    //Produits
//    @GetMapping(value = "/phases/")
//    public List<Phase> listePhases() {
//        return phaseService.getPhases();
//    }

    @DeleteMapping("/phase/{id}")
    public ResponseEntity<?> deletePhase(@PathVariable Long id) {
        phaseService.deletePhase(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
