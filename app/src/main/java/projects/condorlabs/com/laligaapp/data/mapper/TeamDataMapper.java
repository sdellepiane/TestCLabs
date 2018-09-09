package projects.condorlabs.com.laligaapp.data.mapper;

import java.util.ArrayList;
import java.util.List;

import projects.condorlabs.com.laligaapp.data.entity.NextFiveEventsEntity;
import projects.condorlabs.com.laligaapp.domain.model.NextFiveEventsModel;

public class TeamDataMapper {

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
}
