package projects.condorlabs.com.laligaapp.app.ui.listener;

import java.util.List;

import projects.condorlabs.com.laligaapp.domain.model.TeamModel;

public interface TeamListListener {

    void goToTeamDetail(TeamModel teamModel);
    void showListTeams(List<TeamModel> teamModelList);
    void failedLoadData();
}
