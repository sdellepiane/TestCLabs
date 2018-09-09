package projects.condorlabs.com.laligaapp.domain.interactor;

public interface TeamCallback<T> {

    void onGetFiveNextEventsTeamListSuccess(T object);
    void onGetFiveNextEventsTeamListFailure(T object);
    void onMessageError();
}
