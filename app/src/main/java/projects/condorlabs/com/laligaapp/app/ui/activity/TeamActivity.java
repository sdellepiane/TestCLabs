package projects.condorlabs.com.laligaapp.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import projects.condorlabs.com.laligaapp.Constants;
import projects.condorlabs.com.laligaapp.R;
import projects.condorlabs.com.laligaapp.app.ui.core.BaseCompatActivity;
import projects.condorlabs.com.laligaapp.app.ui.listener.TeamListener;
import projects.condorlabs.com.laligaapp.domain.model.NextFiveEventsModel;
import projects.condorlabs.com.laligaapp.domain.model.TeamModel;
import projects.condorlabs.com.laligaapp.presenter.TeamPresenter;
import projects.condorlabs.com.laligaapp.presenter.view.TeamView;

public class TeamActivity extends BaseCompatActivity implements TeamView, TeamListener{

    @BindView(R.id.tviTeamName) TextView tviTeamName;
    @BindView(R.id.tviTeamDescription) TextView tviTeamDescription;
    @BindView(R.id.tviTeamFoundationYear) TextView tviTeamFoundationYear;
    @BindView(R.id.tviNextFiveEvents) TextView tviNextFiveEvents;
    @BindView(R.id.tviWebPage) TextView tviWebPage;
    @BindView(R.id.tviFacebook) TextView tviFacebook;
    @BindView(R.id.tviTwitter) TextView tviTwitter;
    @BindView(R.id.tviInstagram) TextView tviInstagram;
    @BindView(R.id.tviYoutube) TextView tviYoutube;
    @BindView(R.id.iviBadge) ImageView iviBadge;
    @BindView(R.id.iviJersey) ImageView iviJersey;
    @BindView(R.id.vLoading) View vLoading;

    private Bundle bundle;
    private TeamModel teamModel;
    private TeamPresenter teamPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        init();
    }

    private void init(){
        ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        teamModel = (TeamModel) bundle.getSerializable(Constants.TEAM_SELECTED);
        teamPresenter = new TeamPresenter();
        teamPresenter.attachedView(this);
        getNextFiveEvents();
    }

    private void getNextFiveEvents(){
        teamPresenter.getNextFiveEvents(teamModel.getIdTeam(), this);
    }

    @Override
    public void showNextFiveEvents(List<NextFiveEventsModel> nextFiveEventsModelList) {
        tviTeamName.setText(teamModel.getTeamName());
        tviTeamDescription.setText(teamModel.getEnglishDescription());
        tviTeamFoundationYear.setText(String.format(getString(R.string.sFoundedYear), String.valueOf(teamModel.getFormedYear())));
        orderNextFiveEvents(nextFiveEventsModelList);
        validateSocialMedia(teamModel.getWebsite(), tviWebPage);
        validateSocialMedia(teamModel.getFacebook(), tviFacebook);
        validateSocialMedia(teamModel.getTwitter(), tviTwitter);
        validateSocialMedia(teamModel.getInstagram(), tviInstagram);
        validateSocialMedia(teamModel.getYoutube(), tviYoutube);
        Picasso.with(this).load(teamModel.getTeamBadge()).into(iviBadge);
        Picasso.with(this).load(teamModel.getTeamJersey()).into(iviJersey);
    }

    private void orderNextFiveEvents(List<NextFiveEventsModel> nextFiveEventsModelList){
        if(nextFiveEventsModelList.size() == 0){
            tviNextFiveEvents.setVisibility(View.GONE);
        } else {
            StringBuilder nextEvents = new StringBuilder(Constants.EMPTY_STRING);
            int i = 0;
            for (NextFiveEventsModel nextFiveEventsModel : nextFiveEventsModelList) {
                if (i < nextFiveEventsModelList.size() - 1) {
                    nextEvents.append(nextFiveEventsModel.getNameEvent()).append(",");
                } else {
                    nextEvents.append(nextFiveEventsModel.getNameEvent());
                }
                i++;
            }
            tviNextFiveEvents.setText(String.format(getString(R.string.sNextFiveEvents), nextEvents));
        }
    }

    private void validateSocialMedia(String socialMedia, TextView tviSocialMedia){
        if(socialMedia.isEmpty()){
            tviSocialMedia.setVisibility(View.GONE);
        } else {
            tviSocialMedia.setText(socialMedia);
            openLinkMedia(socialMedia, tviSocialMedia);
        }
    }

    private String updateLinkWithHttp(String link){
        if (!link.startsWith("https://") && !link.startsWith("http://")){
            link = "http://" + link;
        }
        return link;
    }

    private void openLinkMedia(final String link, TextView tviLink){
        tviLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(updateLinkWithHttp(link)));
                startActivity(i);
            }
        });
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
    public Context getContext() {
        return this;
    }
}
