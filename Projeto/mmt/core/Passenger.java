package mmt.core;

import java.io.Serializable;

import mmt.core.exceptions.NoSuchItineraryChoiceException;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Comparator;
import java.util.Collections;

/**
* This class represents a passenger.<p>
* A Passenger has an numeric identifier (assigned automatically and sequentially) and a name.
*
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/

class Passenger implements Serializable{

    /** Passenger name. */
    private String _name;

    /** Passenger numeric identifier.<p>
    * The identifier is automatically assigned when a passenger is registered.<p>
    * The number 0 (zero) is attributed to the fisrt passenger.. */
    private int _id;

    /** A Passenger has a category assigned depending on the total money spent in his last 10 trips. */
    private Category _discount;

    /** Itinerary list that the passenger has already completed. */
    private List<Itinerary> _travels; // terceira entrega

    /** Total money spent by a passenger. */
    private float _totalMoneySpent;

    /** Travelling time that a passenger has completed in minutes. */
    private long _totalTime;

    private List<Itinerary> _itineraryCache;

    /**
    * Constructor.
    *
    * @param name passenger name.
    * @param id passenger numeric identifier.
    */
    Passenger(String name, int id){
        _id = id;
        _name = new String(name);
        _discount = new Normal(this);
        _travels = new ArrayList<Itinerary>();
        _totalTime = 0;
    }

    /**
    * Adds an itinerary to the passenger itinerary list .
    *
    * @param itin itinerary to be added.
    */

    void addItinerary(Itinerary itin){
        double sum = 0;
        int size = _travels.size();

        _totalTime += itin.travelTime().toMinutes();

        //updates itinerary cost (if possible) adding it to the total amount of money spent
        _totalMoneySpent += _discount.getDiscount() * itin.getCost();
        _travels.add(0, itin); //adiciona no inicio

        //check last 10 itinerarys completed
        if (size >= 10){
            for (int i = 0; i <10 ; i++)
            sum += _travels.get(i).getCost();
        } else {
            for (Itinerary i : _travels)
            sum += i.getCost();
        }

        //updates discount according to the money spent on passengers last 10 trips
        _discount.update(sum);
    }
    /** Shows all Itineraries saved.
    * @return all itineraries associated to a passenger.
    *
    */
    List<String> showAllItineraries(){
        if(_travels.isEmpty()) return null;

        List<String> list = new ArrayList<String>();
        List<Itinerary> newList = new ArrayList<Itinerary>(_travels);
        Collections.sort(newList, new Itinerary.ItineraryPassengerComparator());

        list.add("== Passageiro " + this.getId() + ": " + this.getName() + " ==" );
        int i = 1; //first itinerary is registered with the id 1
        for ( Itinerary it : newList ){
            list.addAll(it.showItinerary(i));
            i++;
        }
        return list;
    }
    /**
    * @return passenger id.
    */
    int getId(){
        return _id;
    }

    /**
    * @return passenger name.
    *
    */
    String getName(){
        return _name;
    }

    /**
    * Changes passenger name.
    *
    * @param name name to be assigned.
    */
    void changeName( String name ){
        _name = new String( name );
    }

    void changeDiscount( Category discount ){
        _discount = discount;
    }

    /** Saves a temporary itinerary list while the user chooses an option.
    *
    */
    void saveCache( List<Itinerary> cache ){
        _itineraryCache = cache;
    }

    /** Adds an itinerary to a passengers itinerary list. A temporary list saves the itineraies options found for a (*).
    * @param index of the option pretended by the user
    *
    */

    void commitItinerary( int index ) throws NoSuchItineraryChoiceException{
        if(index != 0){
            try{
                this.addItinerary(_itineraryCache.get(index - 1));
            } catch(IndexOutOfBoundsException e ){
                throw new NoSuchItineraryChoiceException(this.getId(), index);
            }
        }

        _itineraryCache = null; //clean the cache
    }

    /**
    * @return a String with all passenger info.
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString(){

        // id|name|category|number of itinerary|total Money Spent|Travelling time

        return  _id + "|" + _name + "|" + _discount.toString() +"|" +
        _travels.size() + "|" + String.format( new Locale("en", "US"), "%.2f",_totalMoneySpent) +
        "|" + String.format( "%02d:%02d", _totalTime/60, _totalTime%60) ;
    }

    /**This nested class is used to compare two passengers by their id.
    */
    public static class PassengerComparator implements Comparator<Passenger>{
        public int compare(Passenger p1, Passenger p2){
            return (p1.getId() - p2.getId());
        }

    }
}
