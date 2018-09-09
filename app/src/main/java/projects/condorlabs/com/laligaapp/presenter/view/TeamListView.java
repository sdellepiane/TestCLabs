package projects.condorlabs.com.laligaapp.presenter.view;

import java.util.List;

import projects.condorlabs.com.laligaapp.domain.model.TeamModel;

public interface TeamListView extends BaseView{

    void showLoading();
    void hideLoading();
    void showMessage();
}
