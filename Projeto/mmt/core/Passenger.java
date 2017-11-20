package mmt.core;

import java.io.Serializable;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

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

    /** Travelling time that a passenger has completed . */
    private LocalTime _totalTime;

    /**
     * Constructor.
     *
     * @param name passenger name.
     * @param id passenger numeric identifier.
     */
    Passenger(String name, int id){
        _id = id;
        _name = name;
        _discount = new Normal(this);
        _travels = new ArrayList<Itinerary>();
        _totalTime = LocalTime.MIN;
    }

    /**
     * adds an itinerary to the passenger itinerary list .
     *
     * @param itin itinerary to be added.
     */

    void addItenerary(Itinerary itin){
        int sum = 0;
        int size = _travels.size();

        //check last 10 itinerarys completed
        if (size >= 10){
            for (int i = 0; i <10 ; i++)
            sum += _travels.get(size-i).getCost();
        } else {
            for (Itinerary i : _travels)
            sum += i.getCost();
        }

        //updates discount according to the money spent on passengers last 10 trips
        _discount.update(sum);

        //updates itinerary cost (if possible) adding it to the total amount of money spent
        _totalMoneySpent += _discount.getDiscount() * itin.getCost();
        _travels.add(itin);
    }

    /**
     * @return passenger id.
     */
    int getID(){
        return _id;
    }

    /**
     * @return passenger name.
     */
    String getName(){
        return _name;
    }

    /**
     * Changes passenger name.
     *
     * @param name name to be assigned.
     */
    void changeName(String name){
        _name = new String(name);
    }

    void changeDiscount(Category discount){
        _discount = discount;
    }

    /**
     * @return a String with all passenger info.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){

        // id|name|category|number of itinerary|total Money Spent|Travelling time

        return  _id + "|" + _name.toString() + "|" + _discount.toString() +"|" +
        _travels.size() + "|" + String.format( new Locale("en", "US"), "%.2f",_totalMoneySpent) +
        "|" + _totalTime.toString() ;
    }
}
