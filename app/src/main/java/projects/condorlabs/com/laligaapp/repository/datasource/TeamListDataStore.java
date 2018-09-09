package projects.condorlabs.com.laligaapp.repository.datasource;

import projects.condorlabs.com.laligaapp.repository.RepositoryCallback;

public interface TeamListDataStore {

    void getTeamList(String nameLeague, RepositoryCallback repositoryCallback);
}
