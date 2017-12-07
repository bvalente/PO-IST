package mmt.core;
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

class Itinerary implements Serializable{

    //list or TreeMap?
    private List<Segment> _segmentList;

    private double _cost;       //desnecessario?
    private int _idItinerario; //provavelmente desnecessario
    private LocalDate _date;

    //apagar?
    Itinerary () { }

    //apagar?
    Itinerary(Segment seg){ }

    Itinerary(Segment seg, LocalDate date){
        _date = date;
        if ( seg != null)
            this.addSegment(seg);
    }

    Itinerary(LocalDate date){
        this(null, date);
    }

    void addSegment(Segment seg){
        _segmentList.add( 0 , seg);
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
        return false; //para compilar
    }

    LocalTime timeOfArrival(){
        Segment seg = _segmentList.get(_segmentList.size() -1);
        return seg.timeOfArrival();
    }
}
