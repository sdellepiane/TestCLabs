package projects.condorlabs.com.laligaapp.app.ui.listener;

import java.util.List;

import projects.condorlabs.com.laligaapp.domain.model.NextFiveEventsModel;

public interface TeamListener {

    void showNextFiveEvents(List<NextFiveEventsModel> nextFiveEventsModelList);
}
