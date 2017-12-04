package mmt.core;
import java.io.Serializable;

import java.util.List;

class Itinerary implements Serializable{

    //list or TreeMap?
    private List<Segment> _segmentList;

    private double _cost;
    private int _idItinerario;

    Itinerary () {

    }
    double getCost(){

        double price = 0;

        for ( Segment segment : _segmentList ){

            price += segment.getCost();

        }
        return price;
    }

    //String toString()
    //depois no SHOWitinerary fazer String.format( new Locale("en", "US"), "%.2f", price))

}
