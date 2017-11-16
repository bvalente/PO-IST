package mmt.core;
import java.io.Serializable;

class Itinerary implements Serializable{

    private int _cost;
    private int _idItinerario;

    Itinerary () {

    }

    int getCost(){
        return _cost;
    }
}
