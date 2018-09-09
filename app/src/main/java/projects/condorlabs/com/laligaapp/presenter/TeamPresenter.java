package projects.condorlabs.com.laligaapp.presenter;

import java.util.List;

import projects.condorlabs.com.laligaapp.app.ui.listener.TeamListener;
import projects.condorlabs.com.laligaapp.data.mapper.TeamDataMapper;
import projects.condorlabs.com.laligaapp.domain.interactor.TeamCallback;
import projects.condorlabs.com.laligaapp.domain.interactor.TeamInteractor;
import projects.condorlabs.com.laligaapp.domain.model.NextFiveEventsModel;
import projects.condorlabs.com.laligaapp.domain.repository.TeamRepository;
import projects.condorlabs.com.laligaapp.presenter.view.TeamView;
import projects.condorlabs.com.laligaapp.repository.datasource.TeamDataRepository;
import projects.condorlabs.com.laligaapp.repository.datasource.TeamDataStoreFactory;

public class TeamPresenter implements Presenter<TeamView>, TeamCallback {

    private TeamView view;
    private TeamRepository teamRepository;
    private TeamInteractor teamInteractor;
    private TeamDataStoreFactory teamDataStoreFactory;
    private TeamListener listener;

    public void getNextFiveEvents(int idTeam, TeamListener listener){
        view.showLoading();
        teamInteractor.getNextFiveEvents(idTeam, this);
        this.listener = listener;
    }

    @Override
    public void onGetFiveNextEventsTeamListSuccess(Object object) {
        view.hideLoading();
        List<NextFiveEventsModel> nextFiveEventsModelList = (List<NextFiveEventsModel>) object;
        listener.showNextFiveEvents(nextFiveEventsModelList);
    }

    @Override
    public void onGetFiveNextEventsTeamListFailure(Object object) {
        view.hideLoading();
    }

    @Override
    public void onMessageError() {
        view.hideLoading();
    }

    @Override
    public void attachedView(TeamView view) {
        this.view = view;
        teamDataStoreFactory = new TeamDataStoreFactory();
        teamRepository = new TeamDataRepository(teamDataStoreFactory, new TeamDataMapper());
        teamInteractor = new TeamInteractor(teamRepository);
    }

    @Override
    public void detachView() {
        view = null;
    }
}
