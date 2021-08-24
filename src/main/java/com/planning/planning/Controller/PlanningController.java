package com.planning.planning.Controller;

import com.planning.planning.Model.Planning;
import com.planning.planning.service.Planning.IPlanningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanningController {
    IPlanningService planningService;

    public PlanningController(IPlanningService planningService) {
        this.planningService = planningService;
    }

    @PostMapping("/planning")
    public ResponseEntity<?> addPlanning(@RequestBody Planning planning) {
        return new ResponseEntity<>(planningService.addPlanning(planning), HttpStatus.CREATED);
    }
    
    @PostMapping("/planning-copy/{id}")
    public ResponseEntity<?> copyPlanning(@PathVariable Long id) {
    	
        return new ResponseEntity<>(planningService.copyPlanning(id), HttpStatus.CREATED);
    }
    
//    @PostMapping("/planning/{id}")
//    public ResponseEntity<?> exportPlanning(@PathVariable Long id, @RequestBody Planning planning) {
//        Planning planningToUpdate = planningService.getPlanning(id);
//        if (planningToUpdate != null) {
//            return new ResponseEntity<> (planningService.exportPlanning(planningToUpdate, planning), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }

    @PutMapping("/planning/{id}")
    public ResponseEntity<?> updatePlanning(@PathVariable Long id, @RequestBody Planning planning) {
        Planning planningToUpdate = planningService.getPlanning(id);
        if (planningToUpdate != null) {
            return new ResponseEntity<> (planningService.updatePlanning(planningToUpdate, planning), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/planning/{id}")
    public ResponseEntity<?> getPlanning(@PathVariable Long id) {
        Planning planning = planningService.getPlanning(id);
        HttpStatus responseStatus = planning != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(planning, responseStatus);
    }

    @GetMapping("/plannings")
    public ResponseEntity<?> getPlannings() {
        return new ResponseEntity<>(planningService.getPlannings(), HttpStatus.OK);
    }

    @DeleteMapping("/planning/{id}")
    public ResponseEntity<?> deletePlanning(@PathVariable Long id) {
        planningService.deletePlanning(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
