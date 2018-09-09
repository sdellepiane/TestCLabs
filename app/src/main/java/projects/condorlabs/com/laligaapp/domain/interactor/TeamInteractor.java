package projects.condorlabs.com.laligaapp.domain.interactor;

import projects.condorlabs.com.laligaapp.domain.repository.TeamRepository;

public class TeamInteractor {

    private final TeamRepository teamRepository;

    public TeamInteractor(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void getNextFiveEvents(int idTeam, final TeamCallback teamCallback){
        this.teamRepository.getFiveNextEvents(idTeam, teamCallback);
    }
}
