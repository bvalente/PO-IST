package mmt.core;

import java.io.Serializable;

/**
* This abstracts class represents a passenger Category.<p>
* Passengers can be Normal, Frequent or Special depending on the money spent in their last 10 travels.
*
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/
abstract class Category implements Serializable{

    Passenger _passenger;

    Category (Passenger passenger){
        _passenger = passenger;
    }

    abstract public String toString();

    /** Discount differs from category to category. */
    abstract float getDiscount();

    /** Updates the category if possible.*/
    abstract void update( double sum );

}
