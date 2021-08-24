package com.planning.planning.service.Planning;

import com.planning.planning.Model.Phase;
import com.planning.planning.Model.Planning;
import com.planning.planning.Model.Seance;
import com.planning.planning.repositories.Plannig.IPlanningRepository;
import com.planning.planning.service.Phase.PhaseService;
import com.planning.planning.service.Seance.SeanceService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlanningService implements IPlanningService{
	SeanceService seanceService;
    IPlanningRepository IPlanningRepository;
    PhaseService phaseService;
    public PlanningService(
    		IPlanningRepository planningRepository,
    		SeanceService seanceService,
    		PhaseService phaseService){
        this.IPlanningRepository = planningRepository;
        this.seanceService =	seanceService;
        this.phaseService = phaseService;
    }

    @Override
    public Planning addPlanning(Planning planning) {
        IPlanningRepository.save(planning);
        return planning;
    }
    
    @Override
    public Planning copyPlanning(Long planningId) {
    	Planning planning = this.getPlanning(planningId);
    	Planning planningCopy = new Planning();
    	planningCopy.setTitre(planning.getTitre().concat("(copie)"));
    	planningCopy.setStartTime(planning.getStartTime());
        IPlanningRepository.save(planningCopy);
        
    	List<Seance> seances = (List<Seance>) planning.getSeances();
    	
    	for (int i = 0; i < seances.size(); i++) {
    		Seance seance = seances.get(i);
    		Seance seanceCopy = new Seance();
    		seanceCopy.setPlanning(planningCopy);
    		seanceCopy.setTitre(seance.getTitre());
    		seanceCopy.setCreneau(seance.getCreneau());
    		seanceCopy.setDate(seance.getDate());
    		seanceCopy.setIndicationEtudiant(seance.getIndicationEtudiant());
    		seanceCopy.setIndicationTuteur(seance.getIndicationTuteur());
    		seanceCopy.setObjectif(seance.getObjectif());
    		seanceService.addSeance(seanceCopy);

        	List<Phase> phases = (List<Phase>) seance.getPhases();
        	for (int y = 0; y < phases.size(); y++) {
        		Phase phase = phases.get(y);
        		Phase phaseCopy = new Phase();
        		phaseCopy.setDiscription(phase.getDiscription());
        		phaseCopy.setEndTime(phase.getEndTime());
        		phaseCopy.setRendu(phase.getRendu());
        		phaseCopy.setSeance(seanceCopy);
        		phaseCopy.setStartTime(phase.getStartTime());
        		phaseCopy.setTitre(phase.getTitre());
        		
        		phaseService.addPhase(phaseCopy);
        	}
    	}
        return planningCopy;
    }
    
    @Override
    public Planning exportPlanning(Planning planningToUpdate, Planning planning) {

        planningToUpdate.setTitre(planning.getTitre() != null ? planning.getTitre() : planningToUpdate.getTitre());
        // planningToUpdate.setStartTime(planning.getDiscription() != null ? planning.getDiscription() : planningToUpdate.getDiscription());
        //planningToUpdate.setRendu(planning.getRendu() != null ? planning.getRendu() : planningToUpdate.getRendu());
        planningToUpdate.setStartTime(planning.getStartTime() != null ? planning.getStartTime() : planningToUpdate.getStartTime());
        //planningToUpdate.setSeances(planning.getSeances()  != null ? planning.getSeances() : planningToUpdate.getSeances());

        if (planning.getSeances() != null) {
            planningToUpdate.setSeances(planning.getSeances());
        }

        IPlanningRepository.save(planningToUpdate);
        return planningToUpdate;
    }

    @Override
    public Planning updatePlanning(Planning planningToUpdate, Planning planning) {

        planningToUpdate.setTitre(planning.getTitre() != null ? planning.getTitre() : planningToUpdate.getTitre());
       // planningToUpdate.setStartTime(planning.getDiscription() != null ? planning.getDiscription() : planningToUpdate.getDiscription());
        //planningToUpdate.setRendu(planning.getRendu() != null ? planning.getRendu() : planningToUpdate.getRendu());
        planningToUpdate.setStartTime(planning.getStartTime() != null ? planning.getStartTime() : planningToUpdate.getStartTime());
        //planningToUpdate.setSeances(planning.getSeances()  != null ? planning.getSeances() : planningToUpdate.getSeances());
        planningToUpdate.setSujet(planning.getSujet() != null ? planning.getSujet() : planningToUpdate.getSujet());
        planningToUpdate.setIntroduction(planning.getIntroduction() != null ? planning.getIntroduction() : planningToUpdate.getIntroduction());

        if (planning.getSeances() != null) {
            planningToUpdate.setSeances(planning.getSeances());
        }

        IPlanningRepository.save(planningToUpdate);
        return planningToUpdate;
    }

    @Override
    public Planning getPlanning(Long planningId) {
        Optional<Planning> planning = IPlanningRepository.findById(planningId);
        return planning.orElse(null);
    }

    @Override
    public List<Planning> getPlannings() {
        return (List<Planning>) IPlanningRepository.findAll();
    }

    @Override
    public void deletePlanning(Long planningId) {
        Optional<Planning> planning = IPlanningRepository.findById(planningId);
        planning.ifPresent(value->IPlanningRepository.delete(value));
    }
}
