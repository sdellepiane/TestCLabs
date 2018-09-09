package projects.condorlabs.com.laligaapp.repository.datasource;

import java.util.List;

import projects.condorlabs.com.laligaapp.data.entity.NextFiveEventsEntity;
import projects.condorlabs.com.laligaapp.data.entity.TeamEntity;
import projects.condorlabs.com.laligaapp.data.mapper.TeamDataMapper;
import projects.condorlabs.com.laligaapp.data.mapper.TeamListDataMapper;
import projects.condorlabs.com.laligaapp.domain.interactor.TeamCallback;
import projects.condorlabs.com.laligaapp.domain.interactor.TeamListCallback;
import projects.condorlabs.com.laligaapp.domain.model.NextFiveEventsModel;
import projects.condorlabs.com.laligaapp.domain.model.TeamModel;
import projects.condorlabs.com.laligaapp.domain.repository.TeamRepository;
import projects.condorlabs.com.laligaapp.repository.RepositoryCallback;

public class TeamDataRepository implements TeamRepository{

    private final TeamDataStoreFactory teamDataStoreFactory;
    private final TeamDataMapper teamDataMapper;

    public TeamDataRepository(TeamDataStoreFactory teamDataStoreFactory, TeamDataMapper teamDataMapper){
        this.teamDataStoreFactory = teamDataStoreFactory;
        this.teamDataMapper = teamDataMapper;
    }

    @Override
    public void getFiveNextEvents(int idTeam, final TeamCallback teamCallback) {
        TeamDataStore teamDataStore = this.teamDataStoreFactory.createSource();
        teamDataStore.getNextFiveEvents(idTeam, new RepositoryCallback() {
            @Override
            public void onSuccess(Object object) {
                List<NextFiveEventsEntity> nextFiveEventsEntityList = (List<NextFiveEventsEntity>) object;
                List<NextFiveEventsModel> nextFiveEventsModelList = teamDataMapper.transformNextFiveEvents(nextFiveEventsEntityList);
                teamCallback.onGetFiveNextEventsTeamListSuccess(nextFiveEventsModelList);
            }

            @Override
            public void onFailure(Exception e) {
                teamCallback.onMessageError();
            }

            @Override
            public void onFailure(Throwable throwable) {
                teamCallback.onMessageError();
            }

            @Override
            public void onCommonMessageError() {
                teamCallback.onMessageError();
            }
        });
    }
}
