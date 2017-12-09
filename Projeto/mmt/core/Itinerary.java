package mmt.core;
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Comparator;
import java.time.Duration;

class Itinerary implements Serializable{

    //list or TreeMap?
    private List<Segment> _segmentList;

    private double _cost;
    private LocalDate _date;

    Itinerary(){ } //apagar

    Itinerary(LocalDate date){
        this(null, date);
    }

    Itinerary(Segment seg, LocalDate date){
        _segmentList = new ArrayList<Segment>();
        _date = date;
        _cost = 0;
        if ( seg != null)
            this.addSegment(seg);
    }

    void addSegment(Segment seg){
        _segmentList.add( 0 , seg);
        _cost += seg.getCost();
    }

    void addSegmentEnd(Segment seg){
        _segmentList.add(seg);
        _cost += seg.getCost();
    }

    double getCost(){

        return _cost;
    }

    LocalDate getDate(){
        return _date;
    }

    List<String> showItinerary(int index){
        List<String> list = new ArrayList<String>();

        list.add('\n' + this.toString(index));
        for (Segment seg : _segmentList){
            list.addAll( seg.showSegment() );
        }
        return list;
    }

    //depois no SHOWitinerary fazer String.format( new Locale("en", "US"), "%.2f", price))

    public String toString(int id){
        return ("Itinerário " + Integer.toString(id) +
                " para " + _date.toString() + " @ " +
                String.format( new Locale("en", "US"), "%.2f",_cost));
    }

    Boolean travelTime(  ){
        //compares departure time of a station and arrival time
        return false; //para compilar
    }

    LocalTime timeOfDeparture(){
        return _segmentList.get(0).timeOfDeparture();
    }

    LocalTime timeOfArrival(){
        return _segmentList.get(_segmentList.size() -1).timeOfArrival();
    }

    public static class ItineraryComparator implements Comparator<Itinerary>{
        public int compare(Itinerary it1, Itinerary it2){
            int x = it1.timeOfDeparture().compareTo(it2.timeOfDeparture() );
            int y = it1.timeOfArrival().compareTo(it2.timeOfArrival() );
            Duration d1 = Duration.between(it1.timeOfDeparture(), it1.timeOfArrival() );
            Duration d2 = Duration.between(it2.timeOfDeparture(), it2.timeOfArrival() );
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
