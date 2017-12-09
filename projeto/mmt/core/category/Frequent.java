package mmt.core;

class Frequent extends Category {

    Frequent(Passenger passenger){
        super(passenger);
    }

    @Override
    public String toString(){
        return "FREQUENTE";
    }

    @Override
    float getDiscount(){
        return 0.85f;
    }

    @Override
    void update ( double sum ) {
        if ( sum <= 250 ){
            _passenger.changeDiscount( new Normal(_passenger) );
        }
        else if ( sum >= 2500 ) {
            _passenger.changeDiscount( new Special(_passenger) );
        }
    }


}
