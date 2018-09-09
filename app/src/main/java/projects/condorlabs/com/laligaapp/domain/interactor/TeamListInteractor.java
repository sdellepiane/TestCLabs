package projects.condorlabs.com.laligaapp.domain.interactor;

import projects.condorlabs.com.laligaapp.domain.repository.TeamListRepository;

public class TeamListInteractor {

    private final TeamListRepository teamListRepository;

    public TeamListInteractor(TeamListRepository teamListRepository) {
        this.teamListRepository = teamListRepository;
    }

    public void getTeamList(String leagueName, final TeamListCallback teamListCallback){
        this.teamListRepository.getTeams(leagueName, teamListCallback);
    }
}
