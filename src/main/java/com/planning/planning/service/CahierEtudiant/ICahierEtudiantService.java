package com.planning.planning.service.CahierEtudiant;

import com.planning.planning.Model.CahierEtudiant;
import com.planning.planning.Model.Planning;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICahierEtudiantService {

    CahierEtudiant addCahierEtudiant(CahierEtudiant cahierEtudiant);
    CahierEtudiant updateCahierEtudiant(CahierEtudiant cahierEtudiantToUpdate, CahierEtudiant cahierEtudiant);
    public CahierEtudiant getCahierEtudiant(Long cahierEtudiantId);
    public List<CahierEtudiant> getCahierEtudiants();
    public void deleteCahierEtudiant(Long cahierEtudiantId);
    public List<CahierEtudiant> getCahierEtudiantByPlanning(Planning planning);

}
