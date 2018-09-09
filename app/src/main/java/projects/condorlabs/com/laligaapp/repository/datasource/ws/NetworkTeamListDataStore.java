package projects.condorlabs.com.laligaapp.repository.datasource.ws;

import java.util.List;

import projects.condorlabs.com.laligaapp.data.entity.TeamEntity;
import projects.condorlabs.com.laligaapp.data.rest.ApiClient;
import projects.condorlabs.com.laligaapp.data.entity.response.TeamListResponse;
import projects.condorlabs.com.laligaapp.repository.RepositoryCallback;
import projects.condorlabs.com.laligaapp.repository.datasource.TeamListDataStore;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkTeamListDataStore implements TeamListDataStore {

    private ApiClient apiClient;

    public NetworkTeamListDataStore(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    @Override
    public void getTeamList(String nameLeague, final RepositoryCallback repositoryCallback) {
        Call<TeamListResponse> call = apiClient.getLaLigaInterface().getTeamList(nameLeague);
        call.enqueue(new Callback<TeamListResponse>() {
            @Override
            public void onResponse(Call<TeamListResponse> call, Response<TeamListResponse> response) {
                if(response != null){
                    List<TeamEntity> teamEntityList = response.body().teamListResponse;
                    repositoryCallback.onSuccess(teamEntityList);
                } else {
                    repositoryCallback.onCommonMessageError();
                }
            }

            @Override
            public void onFailure(Call<TeamListResponse> call, Throwable t) {
                repositoryCallback.onFailure(t);
            }
        });
    }
}
