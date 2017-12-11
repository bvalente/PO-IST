package mmt.core;
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Comparator;
import java.time.Duration;

/**
* This class represents an Itinerary.<p>
* An Itinerary is a route completed in a certain day. It is an aggregate of service segments. <p>
* An Itinerary has a cost correspondent to the sum of partial costs.<p>
* A discount can be applied depending on the passengers category. <p>
* It's not possible to remove an already registered itinerary.
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/


class Itinerary implements Serializable{

    /**
    * List of segments that integrate a Itinerary. <p>
    */
    private List<Segment> _segmentList;

    /** Cost of an Itinerary, correspondent to the sum of the segments price. */
    private double _cost;

    /** Date on which the itinerary occurs. */
    private LocalDate _date;

    Itinerary(){ } //apagar

    /**
    * Constructor.
    * @param date of the itinerary
    */
    Itinerary(LocalDate date){
        this(null, date);
    }

    /**
    * Constructor.
    * @param seg
    * @param date of the itinerary
    */
    Itinerary(Segment seg, LocalDate date){
        _segmentList = new ArrayList<Segment>();
        _date = date;
        _cost = 0;
        if ( seg != null)
        this.addSegment(seg);
    }

    /** Adds a segment to the Itinerary. <p>
    * This function adds to the beggining of the list. <p>
    * It is used because because itinerary search is performed depth-first.
    *
    * @param seg segment to be added
    *
    */
    void addSegment(Segment seg){
        _segmentList.add( 0 , seg);
        _cost += seg.getCost();
    }

    /** Adds a segment to the Itinerary.
    *
    * @param seg segment to be added.
    *
    */
    void addSegmentEnd(Segment seg){
        _segmentList.add(seg);
        _cost += seg.getCost();
    }

    /**
    * @return Itinerary cost.
    *
    */
    double getCost(){

        return _cost;
    }

    /**
    * @return Itinerary date.
    *
    */
    LocalDate getDate(){
        return _date;
    }

    /** Shows all segments that constitute the Itinerary.
    *
    * @param index  */
    List<String> showItinerary(int index){
        List<String> list = new ArrayList<String>();

        list.add('\n' + this.toString(index));
        for (Segment seg : _segmentList){
            list.addAll( seg.showSegment() );
        }
        return list;
    }


    /**
    * @return a String with all the itinerary info.
    * @see java.lang.Object#toString()
    *
    */
    public String toString(int id){
        return ("Itinerário " + Integer.toString(id) +
        " para " + _date.toString() + " @ " +
        String.format( new Locale("en", "US"), "%.2f",_cost));
    }

    Duration travelTime(){
        return Duration.between(this.timeOfDeparture(), this.timeOfArrival());
    }

    /**
    * @return time of departure from the first Train Stop of an itinerary.
    */
    LocalTime timeOfDeparture(){
        return _segmentList.get(0).timeOfDeparture();
    }

    /**
    * @return time of arrival from the last Train Stop of an itinerary.
    */
    LocalTime timeOfArrival(){
        return _segmentList.get(_segmentList.size() -1).timeOfArrival();
    }

    /**This nested class is used to compare two Itineraries by their duration, time of departure and time of arrival.
    */
    public static class ItineraryComparator implements Comparator<Itinerary>{
        public int compare(Itinerary it1, Itinerary it2){
            int x = it1.timeOfDeparture().compareTo(it2.timeOfDeparture() );
            int y = it1.timeOfArrival().compareTo(it2.timeOfArrival() );

            Duration d1 = it1.travelTime();
            Duration d2 = it2.travelTime();
            int z = d1.compareTo(d2);

            //x<0: it1 sai mais cedo
            //y<0: it1 chega mais cedo
            //z<0: it1 tem menor duracao
            if( x < 0 || x == 0 && y < 0 || x == 0 && y == 0 && z < 0){
                return -1;
            }
            return 1;

        }

    }
    /**This nested class is used to compare two Itineraries by their date and also by their duration, time of departure and time of arrival.
    */
    public static class ItineraryPassengerComparator extends ItineraryComparator{
        @Override
        public int compare(Itinerary it1, Itinerary it2){

            LocalDate date1 = it1.getDate();
            LocalDate date2 = it2.getDate();
            int x = date1.compareTo(date2);
            if(x == 0){
                return super.compare(it1, it2);
            }
            return x;
        }
    }

}
