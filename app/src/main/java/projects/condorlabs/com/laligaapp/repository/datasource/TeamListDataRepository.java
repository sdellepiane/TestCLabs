package projects.condorlabs.com.laligaapp.repository.datasource;

import java.util.List;

import projects.condorlabs.com.laligaapp.data.entity.TeamEntity;
import projects.condorlabs.com.laligaapp.data.mapper.TeamListDataMapper;
import projects.condorlabs.com.laligaapp.domain.interactor.TeamListCallback;
import projects.condorlabs.com.laligaapp.domain.model.TeamModel;
import projects.condorlabs.com.laligaapp.domain.repository.TeamListRepository;
import projects.condorlabs.com.laligaapp.repository.RepositoryCallback;

public class TeamListDataRepository implements TeamListRepository{

    private final TeamListDataStoreFactory teamListDataStoreFactory;
    private final TeamListDataMapper teamListDataMapper;

    public TeamListDataRepository(TeamListDataStoreFactory teamListDataStoreFactory, TeamListDataMapper teamListDataMapper){
        this.teamListDataStoreFactory = teamListDataStoreFactory;
        this.teamListDataMapper = teamListDataMapper;
    }

    @Override
    public void getTeams(String leagueName, final TeamListCallback teamListCallback) {
        TeamListDataStore teamListDataStore = this.teamListDataStoreFactory.createSource();
        teamListDataStore.getTeamList(leagueName, new RepositoryCallback() {
            @Override
            public void onSuccess(Object object) {
                List<TeamEntity> teamEntityList = (List<TeamEntity>) object;
                List<TeamModel> teamList = teamListDataMapper.transformTeamList(teamEntityList);
                teamListCallback.onGetTeamListSuccess(teamList);
            }

            @Override
            public void onFailure(Exception e) {
                teamListCallback.onMessageError();
            }

            @Override
            public void onFailure(Throwable throwable) {
                teamListCallback.onMessageError();
            }

            @Override
            public void onCommonMessageError() {
                teamListCallback.onMessageError();
            }
        });
    }
}
