package projects.condorlabs.com.laligaapp.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import projects.condorlabs.com.laligaapp.data.entity.NextFiveEventsEntity;

public class NextFiveEventsResponse {

    @SerializedName("events")
    public List<NextFiveEventsEntity> nextFiveEventsEntityList;
}
