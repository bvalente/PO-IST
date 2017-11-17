package mmt.core;
import java.io.Serializable;

class Itinerary implements Serializable{

    private float _cost;
    private int _idItinerario;

    Itinerary () {

    }

    float getCost(){
        return _cost;
    }
}
