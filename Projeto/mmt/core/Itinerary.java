package mmt.core;
import java.io.Serializable;

import java.util.List;

class Itinerary implements Serializable{

    //list or TreeMap?
    private List<Segment> _segmentList;

    private float _cost;
    private int _idItinerario;

    Itinerary () {

    }

    /*float getCost(){
        float price;
        for ( Segment segment : _segmentList ){

            price +=
            //depois no SHOWitinerary fazer String.format( new Locale("en", "US"), "%.2f", price))

        }
    }

    */
}
