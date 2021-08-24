package com.planning.planning.service.CahierTuteur;

import com.planning.planning.Model.CahierTuteur;
import com.planning.planning.repositories.CahierTuteur.ICahierTuteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CahierTuteurService implements ICahierTuteurService{

    ICahierTuteurRepository cahierTuteurRepository;

    public CahierTuteurService(ICahierTuteurRepository cahierTuteurRepository) {
        this.cahierTuteurRepository = cahierTuteurRepository;
    }

    @Override
    public CahierTuteur addCahierTuteur(CahierTuteur cahierTuteur) {
        cahierTuteurRepository.save(cahierTuteur);
        return cahierTuteur;
    }

    @Override
    public CahierTuteur updateCahierTuteur(CahierTuteur cahierTuteurToUpdate, CahierTuteur cahierTuteur) {
        cahierTuteurToUpdate.setIndicationsTuteur(cahierTuteur.getIndicationsTuteur() != null ? cahierTuteur.getIndicationsTuteur() : cahierTuteurToUpdate.getIndicationsTuteur());
        cahierTuteurToUpdate.setCahierEtudiant(cahierTuteur.getCahierEtudiant() != null ? cahierTuteur.getCahierEtudiant() : cahierTuteurToUpdate.getCahierEtudiant());

        cahierTuteurRepository.save(cahierTuteurToUpdate);
        return cahierTuteurToUpdate;
    }

    @Override
    public CahierTuteur getCahierTuteur(Long cahierTuteurId) {
        Optional<CahierTuteur> cahierTuteur = cahierTuteurRepository.findById(cahierTuteurId);
        return cahierTuteur.orElse(null);
    }

    @Override
    public List<CahierTuteur> getCahierTuteurs() {
        return (List<CahierTuteur>) cahierTuteurRepository.findAll();
    }

    @Override
    public void deleteCahierTuteur(Long cahierTuteurId) {
        Optional<CahierTuteur> cahierTuteur = cahierTuteurRepository.findById(cahierTuteurId);
        cahierTuteur.ifPresent(value-> cahierTuteurRepository.delete(value));

    }
}
