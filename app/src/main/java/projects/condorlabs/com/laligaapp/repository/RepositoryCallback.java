package projects.condorlabs.com.laligaapp.repository;

public interface RepositoryCallback<T> {

    void onSuccess(T object);
    void onFailure(Exception e);
    void onFailure(Throwable throwable);
    void onCommonMessageError();
}
