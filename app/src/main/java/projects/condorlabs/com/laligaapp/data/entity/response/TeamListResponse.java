package projects.condorlabs.com.laligaapp.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import projects.condorlabs.com.laligaapp.data.entity.TeamEntity;

public class TeamListResponse {

    @SerializedName("teams")
    public List<TeamEntity> teamListResponse;
}
