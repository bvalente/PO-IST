package mmt.core;

/**
* This class represents a Normal passenger.<p>
* A Passenger is Normal if in the last 10 travels spent less than 250 euros.
*
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/

class Normal extends Category{

    Normal(Passenger passenger){
        super(passenger);
    }

    @Override
    public String toString(){
        return "NORMAL";
    }

    @Override
    float getDiscount(){
        return 1f;
    }

    @Override
    void update( double sum ) {
        if ( sum >= 2500 ){
            _passenger.changeDiscount( new Special(_passenger) );
        }
        else if  ( sum >= 250 ){
            _passenger.changeDiscount( new Frequent(_passenger) );
        }
    }
}
