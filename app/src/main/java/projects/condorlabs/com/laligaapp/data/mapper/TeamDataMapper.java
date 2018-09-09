package projects.condorlabs.com.laligaapp.data.mapper;

import java.util.ArrayList;
import java.util.List;

import projects.condorlabs.com.laligaapp.Constants;
import projects.condorlabs.com.laligaapp.data.entity.NextFiveEventsEntity;
import projects.condorlabs.com.laligaapp.data.entity.TeamEntity;
import projects.condorlabs.com.laligaapp.domain.model.NextFiveEventsModel;
import projects.condorlabs.com.laligaapp.domain.model.TeamModel;

public class TeamDataMapper {

    private static TeamDataMapper mInstance;

    public List<NextFiveEventsModel> transformNextFiveEvents(List<NextFiveEventsEntity> nextFiveEventsEntityList){
        List<NextFiveEventsModel> nextFiveEventsModelList = new ArrayList<>();
        if(nextFiveEventsEntityList != null && nextFiveEventsEntityList.size() > 0){
            for(NextFiveEventsEntity nextFiveEventsEntity : nextFiveEventsEntityList){
                nextFiveEventsModelList.add(transformNextFiveEventsEntity(nextFiveEventsEntity));
            }
        }

        return nextFiveEventsModelList;
    }

    private NextFiveEventsModel transformNextFiveEventsEntity(NextFiveEventsEntity nextFiveEventsEntity){
        NextFiveEventsModel nextFiveEventsModel = null;
        if(nextFiveEventsEntity != null){
            nextFiveEventsModel = new NextFiveEventsModel();
            nextFiveEventsModel.setIdEvent(nextFiveEventsEntity.getIdEvent());
            nextFiveEventsModel.setNameEvent(nextFiveEventsEntity.getStrEvent());
        }
        return nextFiveEventsModel;
    }

    public static synchronized TeamDataMapper getInstance() {
        if (mInstance == null) {
            mInstance = new TeamDataMapper();
        }
        return mInstance;
    }
}
