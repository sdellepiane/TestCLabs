package projects.condorlabs.com.laligaapp.presenter;

import java.util.List;

import projects.condorlabs.com.laligaapp.app.ui.listener.TeamListListener;
import projects.condorlabs.com.laligaapp.data.mapper.TeamListDataMapper;
import projects.condorlabs.com.laligaapp.domain.interactor.TeamListCallback;
import projects.condorlabs.com.laligaapp.domain.interactor.TeamListInteractor;
import projects.condorlabs.com.laligaapp.domain.model.TeamModel;
import projects.condorlabs.com.laligaapp.domain.repository.TeamListRepository;
import projects.condorlabs.com.laligaapp.presenter.view.TeamListView;
import projects.condorlabs.com.laligaapp.repository.datasource.TeamListDataRepository;
import projects.condorlabs.com.laligaapp.repository.datasource.TeamListDataStoreFactory;

public class TeamListPresenter implements Presenter<TeamListView>, TeamListCallback {

    private TeamListView view;
    private TeamListRepository teamListRepository;
    private TeamListInteractor teamListInteractor;
    private TeamListDataStoreFactory teamListDataStoreFactory;
    private TeamListListener listener;

    public void getTeamList(String leagueName, TeamListListener listener){
        view.showLoading();
        teamListInteractor.getTeamList(leagueName, this);
        this.listener = listener;
    }

    @Override
    public void onGetTeamListSuccess(Object object) {
        view.hideLoading();
        List<TeamModel> teamModelList = (List<TeamModel>) object;
        listener.showListTeams(teamModelList);
    }

    @Override
    public void onGetTeamListFailure(Object object) {
        view.hideLoading();
        listener.failedLoadData();
    }

    @Override
    public void onMessageError() {
        view.hideLoading();
    }

    @Override
    public void attachedView(TeamListView view) {
        this.view = view;
        teamListDataStoreFactory = new TeamListDataStoreFactory();
        teamListRepository = new TeamListDataRepository(teamListDataStoreFactory, new TeamListDataMapper());
        teamListInteractor = new TeamListInteractor(teamListRepository);
    }

    @Override
    public void detachView() {
        view = null;
    }
}
