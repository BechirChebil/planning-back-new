package com.planning.planning.repositories.CahierEtudiant;

import com.planning.planning.Model.CahierEtudiant;
import com.planning.planning.Model.Planning;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ICahierEtudiantRepository extends CrudRepository<CahierEtudiant,Long> {
	List<CahierEtudiant> findByPlanning(Planning planning);
}
