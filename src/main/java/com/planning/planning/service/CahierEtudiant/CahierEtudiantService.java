package com.planning.planning.service.CahierEtudiant;


import com.planning.planning.Model.CahierEtudiant;
import com.planning.planning.Model.Planning;
import com.planning.planning.repositories.CahierEtudiant.ICahierEtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CahierEtudiantService implements ICahierEtudiantService {

    ICahierEtudiantRepository cahierEtudiantRepository;

    public CahierEtudiantService(ICahierEtudiantRepository cahierEtudiantRepository) {
        this.cahierEtudiantRepository = cahierEtudiantRepository;
    }

    @Override
    public CahierEtudiant addCahierEtudiant(CahierEtudiant cahierEtudiant) {
        cahierEtudiantRepository.save(cahierEtudiant);
        return cahierEtudiant;
    }

    @Override
    public CahierEtudiant updateCahierEtudiant(CahierEtudiant cahierEtudiantToUpdate, CahierEtudiant cahierEtudiant) {

        cahierEtudiantToUpdate.setIntroduction(cahierEtudiant.getIntroduction() != null ? cahierEtudiant.getIntroduction() : cahierEtudiantToUpdate.getIntroduction());
        cahierEtudiantToUpdate.setSujet(cahierEtudiant.getSujet() != null ? cahierEtudiant.getSujet() : cahierEtudiantToUpdate.getSujet());
        cahierEtudiantToUpdate.setIndicationEtudiant(cahierEtudiant.getIndicationEtudiant() != null ? cahierEtudiant.getIndicationEtudiant() : cahierEtudiantToUpdate.getIndicationEtudiant());
        cahierEtudiantToUpdate.setIndicationsTuteur(cahierEtudiant.getIndicationsTuteur() != null ? cahierEtudiant.getIndicationsTuteur() : cahierEtudiantToUpdate.getIndicationsTuteur());
        cahierEtudiantToUpdate.setPlanning(cahierEtudiant.getPlanning()  != null ? cahierEtudiant.getPlanning() : cahierEtudiantToUpdate.getPlanning());

        cahierEtudiantRepository.save(cahierEtudiantToUpdate);
        return cahierEtudiantToUpdate;
    }

    @Override
    public CahierEtudiant getCahierEtudiant(Long cahierEtudiantId) {
        Optional<CahierEtudiant> cahierEtudiant = cahierEtudiantRepository.findById(cahierEtudiantId);
        return cahierEtudiant.orElse(null);
    }

    @Override
    public List<CahierEtudiant> getCahierEtudiants() {
        return (List<CahierEtudiant>) cahierEtudiantRepository.findAll();
    }
    
    @Override
    public List<CahierEtudiant> getCahierEtudiantByPlanning(Planning planning) {
        return (List<CahierEtudiant>) cahierEtudiantRepository.findByPlanning(planning);
    }
    
    @Override
    public void deleteCahierEtudiant(Long cahierEtudiantId) {
        Optional<CahierEtudiant> cahierEtudiant = cahierEtudiantRepository.findById(cahierEtudiantId);
        cahierEtudiant.ifPresent(value -> cahierEtudiantRepository.delete(value));

    }
}
