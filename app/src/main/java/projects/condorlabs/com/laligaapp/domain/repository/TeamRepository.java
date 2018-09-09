package projects.condorlabs.com.laligaapp.domain.repository;

import projects.condorlabs.com.laligaapp.domain.interactor.TeamCallback;

public interface TeamRepository {

    void getFiveNextEvents(int idTeam, TeamCallback teamCallback);
}
