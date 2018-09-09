package projects.condorlabs.com.laligaapp.repository.datasource;

import projects.condorlabs.com.laligaapp.data.rest.ApiClient;
import projects.condorlabs.com.laligaapp.repository.datasource.ws.NetworkTeamListDataStore;

public class TeamListDataStoreFactory {

    public TeamListDataStore createSource(){
        TeamListDataStore teamListDataStore = createNetworkDataStore();
        return teamListDataStore;
    }

    public TeamListDataStore createNetworkDataStore() {
        ApiClient restApi = new ApiClient();
        return new NetworkTeamListDataStore(restApi);
    }
}
