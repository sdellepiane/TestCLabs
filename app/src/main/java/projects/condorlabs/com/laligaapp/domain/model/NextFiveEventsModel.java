package projects.condorlabs.com.laligaapp.domain.model;

import java.io.Serializable;

public class NextFiveEventsModel implements Serializable{

    private int idEvent;
    private String nameEvent;

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }
}
