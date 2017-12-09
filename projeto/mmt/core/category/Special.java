package mmt.core;

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
