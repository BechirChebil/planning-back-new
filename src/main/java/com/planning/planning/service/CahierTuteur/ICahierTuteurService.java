package com.planning.planning.service.CahierTuteur;


import com.planning.planning.Model.CahierTuteur;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICahierTuteurService {

    CahierTuteur addCahierTuteur(CahierTuteur cahierTuteur);
    CahierTuteur updateCahierTuteur(CahierTuteur cahierTuteurToUpdate, CahierTuteur cahierTuteur);
    public CahierTuteur getCahierTuteur(Long cahierTuteurId);
    public List<CahierTuteur> getCahierTuteurs();
    public void deleteCahierTuteur(Long cahierTuteurId);
}
