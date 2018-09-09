package projects.condorlabs.com.laligaapp.repository.datasource;

import projects.condorlabs.com.laligaapp.repository.RepositoryCallback;

public interface TeamDataStore {

    void getNextFiveEvents(int idEvent, RepositoryCallback repositoryCallback);
}
