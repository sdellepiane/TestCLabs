package projects.condorlabs.com.laligaapp.domain.interactor;

public interface TeamListCallback<T> {

    void onGetTeamListSuccess(T object);
    void onGetTeamListFailure(T object);
    void onMessageError();
}
