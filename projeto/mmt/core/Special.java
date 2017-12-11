package mmt.core;

/**
* This class represents a Normal passenger.<p>
* A Passenger is Normal if in the last 10 travels spent between 250 and 2500 euros.
*
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/

class Special extends Category {

    Special(Passenger passenger){
        super(passenger);
    }

    @Override
    public String toString(){
        return "ESPECIAL";
    }

    @Override
    float getDiscount(){
        return 0.5f;
    }

    @Override
    void update( double sum ) {
        if ( sum <= 250 ){
            _passenger.changeDiscount( new Normal(_passenger) );
        }
        else if ( sum <= 2500 ) {
            _passenger.changeDiscount( new Frequent(_passenger) );
        }
    }
}
