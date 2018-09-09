package projects.condorlabs.com.laligaapp.app.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import projects.condorlabs.com.laligaapp.Constants;
import projects.condorlabs.com.laligaapp.R;
import projects.condorlabs.com.laligaapp.app.ui.adapter.TeamsAdapter;
import projects.condorlabs.com.laligaapp.app.ui.core.BaseCompatActivity;
import projects.condorlabs.com.laligaapp.app.ui.listener.TeamListListener;
import projects.condorlabs.com.laligaapp.app.ui.utils.DialogUtil;
import projects.condorlabs.com.laligaapp.domain.model.TeamModel;
import projects.condorlabs.com.laligaapp.presenter.TeamListPresenter;
import projects.condorlabs.com.laligaapp.presenter.view.TeamListView;

public class TeamListActivity extends BaseCompatActivity implements TeamListView, TeamListListener,
    DialogUtil.OnDialogListener{

    @BindView(R.id.tviTeamTitle) TextView tviTeamTitle;
    @BindView(R.id.rviTeams) RecyclerView rviTeams;
    @BindView(R.id.vLoading) View vLoading;
    @BindView(R.id.fabFilter) FloatingActionButton fabFilter;

    private TeamListListener listener;
    private TeamListPresenter presenter;
    private String leagueName;
    private Dialog dialog;
    private DialogUtil dialogUtil;
    private List<TeamModel> teamModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        init();
        loadListTeams(leagueName);
    }

    private void init(){
        listener = this;
        ButterKnife.bind(this);
        fabFilter.setEnabled(false);
        presenter = new TeamListPresenter();
        presenter.attachedView(this);
        iniRecyclerView();
        leagueName = getString(R.string.sInitLeagueName);
        tviTeamTitle.setText(leagueName);
        dialogUtil = new DialogUtil(this);
    }

    private void iniRecyclerView(){
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rviTeams.setLayoutManager(mLayoutManager);
        rviTeams.setItemAnimator(new DefaultItemAnimator());
    }

    private void loadListTeams(String leagueName){
        presenter.getTeamList(leagueName, listener);
    }

    @Override
    public void showLoading() {
        vLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        vLoading.setVisibility(View.GONE);
    }

    @Override
    public void showMessage() {

    }

    @Override
    public void goToTeamDetail(TeamModel teamModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.TEAM_SELECTED, teamModel);
        nextData(TeamActivity.class, bundle, false);
    }

    @Override
    public void showListTeams(List<TeamModel> teamModelList) {
        fabFilter.setEnabled(true);
        this.teamModelList = teamModelList;
        TeamsAdapter teamsAdapter = new TeamsAdapter(this, this, teamModelList);
        rviTeams.setAdapter(teamsAdapter);
    }

    @Override
    public void failedLoadData() {
        fabFilter.setEnabled(true);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @OnClick(R.id.fabFilter)
    public void clickFilter(){
        fabFilter.setEnabled(false);
        openDialogToFilterLeague();
    }

    private void openDialogToFilterLeague(){
        dialog = dialogUtil.createCustomDialog(TeamListActivity.this);
        dialog.show();
    }

    @Override
    public void onLeagueSelected(String leagueName) {
        teamModelList.clear();
        tviTeamTitle.setText(leagueName);
        loadListTeams(leagueName);
    }
}
