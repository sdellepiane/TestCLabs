package projects.condorlabs.com.laligaapp.repository.datasource;

import projects.condorlabs.com.laligaapp.data.rest.ApiClient;
import projects.condorlabs.com.laligaapp.repository.datasource.ws.NetworkTeamDataStore;

public class TeamDataStoreFactory {

    public TeamDataStore createSource(){
        TeamDataStore teamDataStore = createNetworkDataStore();
        return teamDataStore;
    }

    public TeamDataStore createNetworkDataStore() {
        ApiClient restApi = new ApiClient();
        return new NetworkTeamDataStore(restApi);
    }
}
