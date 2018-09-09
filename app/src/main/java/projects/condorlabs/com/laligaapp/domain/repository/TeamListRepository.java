package projects.condorlabs.com.laligaapp.domain.repository;

import projects.condorlabs.com.laligaapp.domain.interactor.TeamListCallback;

public interface TeamListRepository {

    void getTeams(String leagueName, TeamListCallback teamListCallback);
}
