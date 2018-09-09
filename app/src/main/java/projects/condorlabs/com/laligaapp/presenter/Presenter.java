package projects.condorlabs.com.laligaapp.presenter;

public interface Presenter<V> {

    void attachedView(V view);
    void detachView();
}
