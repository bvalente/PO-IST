package mmt.core;
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Locale;

class Itinerary implements Serializable{

    //list or TreeMap?
    private List<Segment> _segmentList;

    private double _cost;
    private int _idItinerario;
    private LocalDate _date;

    Itinerary () {

    }

    Itinerary(Segment seg){
        //para compilar
    }

    double getCost(){

        double price = 0;

        for ( Segment segment : _segmentList ){

            price += segment.getCost();

        }
        return price;
    }

    List<String> showItinerary(){
        List<String> list = new ArrayList<String>();

        list.add(this.toString());
        for (Segment seg : _segmentList){
            list.addAll( seg.showSegment() );
        }
        return list;
    }

    //depois no SHOWitinerary fazer String.format( new Locale("en", "US"), "%.2f", price))
    @Override
    public String toString(){
        return ("Itinerário " + Integer.toString(_idItinerario) +
                " para " + _date.toString() + " @ " +
                String.format( new Locale("en", "US"), "%.2f",_cost));
    }

    Boolean travelTime(  ){
        //compares departure time of a station and arrival time 
    }
}
