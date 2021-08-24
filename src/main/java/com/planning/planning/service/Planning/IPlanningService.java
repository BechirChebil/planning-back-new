package com.planning.planning.service.Planning;

import com.planning.planning.Model.Planning;

import java.util.List;

public interface IPlanningService {

    public Planning addPlanning(Planning planning);
    public Planning copyPlanning(Long planningId);
    public Planning exportPlanning(Planning planningToUpdate, Planning planning);
    public Planning updatePlanning(Planning planningToUpdate, Planning planning);
    public Planning getPlanning(Long planningId);
    public List<Planning> getPlannings();
    public void deletePlanning(Long planningId);
}
