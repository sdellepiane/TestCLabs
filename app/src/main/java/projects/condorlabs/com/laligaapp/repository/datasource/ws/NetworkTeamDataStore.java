package projects.condorlabs.com.laligaapp.repository.datasource.ws;

import java.util.List;

import projects.condorlabs.com.laligaapp.data.entity.NextFiveEventsEntity;
import projects.condorlabs.com.laligaapp.data.entity.response.NextFiveEventsResponse;
import projects.condorlabs.com.laligaapp.data.rest.ApiClient;
import projects.condorlabs.com.laligaapp.repository.RepositoryCallback;
import projects.condorlabs.com.laligaapp.repository.datasource.TeamDataStore;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkTeamDataStore implements TeamDataStore {

    private ApiClient apiClient;

    public NetworkTeamDataStore(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    @Override
    public void getNextFiveEvents(int idEvent, final RepositoryCallback repositoryCallback) {
        Call<NextFiveEventsResponse> call = apiClient.getLaLigaInterface().getNextFiveEvents(idEvent);
        call.enqueue(new Callback<NextFiveEventsResponse>() {
            @Override
            public void onResponse(Call<NextFiveEventsResponse> call, Response<NextFiveEventsResponse> response) {
                if(response != null){
                    List<NextFiveEventsEntity> nextFiveEventsEntityList = response.body().nextFiveEventsEntityList;
                    repositoryCallback.onSuccess(nextFiveEventsEntityList);
                } else {
                    repositoryCallback.onCommonMessageError();
                }
            }

            @Override
            public void onFailure(Call<NextFiveEventsResponse> call, Throwable t) {
                repositoryCallback.onFailure(t);
            }
        });
    }
}
